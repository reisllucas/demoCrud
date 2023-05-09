import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PersonListComponent } from './person-list/person-list.component';
import { PersonFormComponent } from './person-form/person-form.component';
import { PersonResolver } from './person.resolver';
import { CountryResolver } from '../country/country.resolver';


const routes: Routes = [
  {
    path: '', component: PersonListComponent,
    resolve: {
      people: PersonResolver
    }
  },
  {
    path: 'form', component: PersonFormComponent,
    resolve: {
      countries: CountryResolver
    }
  },
  {
    path: 'form/:id', component: PersonFormComponent,
    resolve: {
      countries: CountryResolver,
      person: PersonResolver
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class PersonRoutingModule { }
