import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Person } from '../person';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { FormGroup, FormBuilder, FormControl  } from '@angular/forms';
import { MatSort, Sort } from '@angular/material/sort';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';
import { PersonService } from '../person.service';
import { DialogService } from '../../dialog/dialog.service';

@Component({
  selector: 'app-person-list',
  templateUrl: './person-list.component.html',
  styleUrls: ['./person-list.component.scss']
})
export class PersonListComponent implements OnInit {

  @ViewChild('paginator') paginator: MatPaginator;
  @ViewChild('tbSort') sort = new MatSort();
  public dataSource: MatTableDataSource<Person>;
  private people: Person[];
  public displayedColumns: string[] = ['id','name','phone','birthDay','email','country','actions'];
  public pageSizes = [5,10,30,50]
  public formFilter: FormGroup;
  private filter: string;
  private _unsubscribeAll = new Subject();

  constructor(  private _activatedRoute: ActivatedRoute,
                private _formBuilder: FormBuilder,
                private router: Router,
                private _personService: PersonService,
                private _dialogService: DialogService){}


  ngOnInit(): void {
    this.people = this._activatedRoute.snapshot.data['people'];
    this.dataSource = new MatTableDataSource<Person>(this.people)
    this.buildForm();
  }

  ngAfterViewInit() {
    this.configDataSource();
  }

  configDataSource() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
    this.dataSource.sortingDataAccessor = (row:any,columnName:string) : string => {

      return row[columnName];
    };
  }

  applyFilter(filterValue: string) {
    if (!filterValue) return;
    this.filter = filterValue.trim().toLowerCase(); 
    this.dataSource.filter = this.filter;
  }

  buildForm(): void {
    this.formFilter = this._formBuilder.group({
      filterTxt: new FormControl('')
    });
    this.formFilter
    .get('filterTxt')?.valueChanges
    .pipe(takeUntil(this._unsubscribeAll))
    .subscribe(filterValue => {
      this.applyFilter(filterValue);
    })
  }
  edit(id: any) {
    this.router.navigate([`/person/form/${id}`]);
  }

  delete(person: Person) {
    this._dialogService.openConfirmDialog("Confirm", `Do you confirm the deletion of the person ${person.name} (${person.id}) ?`, () => {
      this._personService.delete(person.id)
      .subscribe(()=>{
        this.removeRow(person);
        console.log(`removeu`)
      },
      response => {
        console.log(`error`)
      })
    })
    
  }

  removeRow(person: Person) {
    let index = this.people.findIndex(p => p.id == person.id)
    this.people.splice(index,1);
    this.dataSource = new MatTableDataSource<Person>(this.people);
    this.configDataSource();
    this.applyFilter(this.filter);
  }
  
}
