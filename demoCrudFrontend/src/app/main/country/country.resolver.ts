import { Injectable } from '@angular/core';
import {
  Router, Resolve,
  RouterStateSnapshot,
  ActivatedRouteSnapshot
} from '@angular/router';
import { Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';
import { Country } from './country';
import { CountryService } from './country.service';

@Injectable({
  providedIn: 'root'
})
export class CountryResolver implements Resolve<Country> {

  constructor(private _countryService: CountryService){}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Country> {

    return this._countryService.findAll()
    .pipe(map( (c: Country) => {
      return c;
    }));
  }
}
