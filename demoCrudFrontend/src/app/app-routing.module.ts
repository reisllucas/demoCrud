import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
{
    path: '', loadChildren: () => import('./main/home/home.module').then(m => m.HomeModule)
},
{
    path: 'country', loadChildren: () => import('./main/country/country.module').then(m => m.CountryModule)
},
{
    path: 'person', loadChildren: () => import('./main/person/person.module').then(m => m.PersonModule)
},
{
    path: '**',
    redirectTo: ''
}
];

@NgModule({
    imports: [RouterModule.forRoot(routes, { useHash: true })],
    exports: [RouterModule]
})
export class AppRoutingModule { }