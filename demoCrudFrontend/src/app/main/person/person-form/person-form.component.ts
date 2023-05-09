import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup, FormBuilder, FormControl  } from '@angular/forms';
import { Person } from '../person';
import { Observable } from 'rxjs';
import { Country } from '../../country/country';
import { Subject } from 'rxjs';
import { takeUntil, map } from 'rxjs/operators';
import { DialogService } from '../../dialog/dialog.service';
import { PersonService } from '../person.service';

@Component({
  selector: 'app-person-form',
  templateUrl: './person-form.component.html',
  styleUrls: ['./person-form.component.scss']
})
export class PersonFormComponent {

  public form: FormGroup;
  public disabled = true
  public inputType = 'number';
  private person: Person;
  public countries: Country[];
  public filteredCountries: Observable<any>;
  public countryControl: FormControl;
  private _unsubscribeAll = new Subject();

  constructor(  private _activatedRoute: ActivatedRoute,
    private _formBuilder: FormBuilder,
    private router: Router,
    private _personService: PersonService,
    private _dialogService: DialogService){}

  ngOnInit(): void {
    this.countries = this._activatedRoute.snapshot.data['countries'] || [];
    this.person = this._activatedRoute.snapshot.data['person'] || new Person();
    this.buildForm();

  }

  buildForm(): void {
    console.log(this.person);
    console.log(this.findCountry(this.person.country))
    this.countryControl = new FormControl(this.findCountry(this.person.country));
    this.form = this._formBuilder.group({
      id: new FormControl({ value: this.person.id || ' - ', disabled: true }),
      name: new FormControl( this.person.name),
      phone: new FormControl(this.person.phone),
      birthDay: new FormControl(this.person.birthDay),
      zipCode: new FormControl(this.person.zipCode),
      address: new FormControl(this.person.address),
      email: new FormControl(this.person.email),
      country: this.countryControl,
      city: new FormControl(this.person.city),
      state: new FormControl(this.person.state)

    });
    this.filteredCountries = this.countryControl.valueChanges.pipe(
      
      map(value => this.applyFilter(value || '')),
    );
  }

  private findCountry(filterValue: string) : Country | null{
    return this.countries.find(c =>  c.value.includes(filterValue)) || null;
  }

  public displayCountry(c: Country): string {
    return c ? `${c.description} (${c.value})` : '';
  }

  private applyFilter(value: any): Country[] {
    if (typeof (value) === "object")  return [value]; 

    const filterValue = value ? value.toLowerCase().trim() : '' ;

    return this.countries.filter(c => filterValue == '' || `${c.description}(${c.value})`.toLowerCase().includes(filterValue));
  }

  public isCountryReadyOnly(value: any) {
    return (typeof (value) === "object") 
  }

  onSubmit() {
    console.log(this.form.value)
    let p = this.resolvePerson(this.form.value);
    console.log(p)
    if (this.person.id) {
      this._dialogService.openConfirmDialog("Confirm", `Do you confirm the change of the person ${this.person.name} (${this.person.id}) ?`, () => {
        this._personService.put(p.id, p)
        .subscribe(()=>{
          this.back();
          console.log(`alterou`)
        },
        response => {
          console.log(`error ao alterar`)
        });
      })
    } else {
      this._personService.post(p)
      .subscribe(()=>{
        this.back();
        console.log(`salvou`)
      },
      response => {
        console.log(`error ao salvar`)
      });
    }
    
  }

  delete() {
    this._dialogService.openConfirmDialog("Confirm", `Do you confirm the deletion of the person ${this.person.name} (${this.person.id}) ?`, () => {
      this._personService.delete(this.person.id)
      .subscribe(()=>{
        this.back();
        console.log(`removeu`)
      },
      response => {
        console.log(`error ao excluir`)
      })
    })
  }

  back() {
    this.router.navigate([`/person`]);

  }

  resolvePerson(person: any) {

    let p : any = {...person};
    if (person.birthDay) {
      p.birthDay = `${person.birthDay.getFullYear()}-${this.completeNumber(person.birthDay.getMonth()+1)}-${this.completeNumber(person.birthDay.getDate())}`
    }
    if (person.country) {
      p.country = person.country.value;
    }
    p.id = this.person.id

    return p;
  }

  completeNumber(num: any) {
    return ("00" + num).slice(-2)
  }

}
