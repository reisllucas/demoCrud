import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Country } from './country';

@Injectable({
  providedIn: 'root'
})
export class CountryService {

  private url = 'rs/country';

  constructor(private http: HttpClient) { }

  findAll() : Observable<Country> {

    return this.http.get<Country>(this.url)

  }
}
