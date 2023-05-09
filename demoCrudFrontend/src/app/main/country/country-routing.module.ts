import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CountryListComponent } from './country-list/country-list.component';
import { CountryResolver } from './country.resolver';

const routes: Routes = [
  {
    path: '', component: CountryListComponent,
    resolve: {
      countries: CountryResolver
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class CountryRoutingModule { }
