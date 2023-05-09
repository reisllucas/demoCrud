import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Country } from '../country';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { FormGroup, FormBuilder, FormControl  } from '@angular/forms';
import { MatSort, Sort } from '@angular/material/sort';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';

@Component({
  selector: 'app-country-list',
  templateUrl: './country-list.component.html',
  styleUrls: ['./country-list.component.scss']
})
export class CountryListComponent implements OnInit{

  @ViewChild('paginator') paginator: MatPaginator;
  @ViewChild('tbSort') sort = new MatSort();
  public dataSource: MatTableDataSource<Country>;
  public displayedColumns: string[] = ['name'];
  public pageSizes = [5,10,30,50]
  public formFilter: FormGroup;
  private _unsubscribeAll = new Subject();

  constructor(  private _activatedRoute: ActivatedRoute,
                private _formBuilder: FormBuilder){}

  ngOnInit(): void {
      this.dataSource = new MatTableDataSource<Country>(this._activatedRoute.snapshot.data['countries'])
      this.buildForm();
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
    this.dataSource.sortingDataAccessor = (row:Country,columnName:string) : string => {
      return `${row.description} (${row.value})`;
    };
  }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim().toLowerCase(); 
    this.dataSource.filter = filterValue;
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

}
