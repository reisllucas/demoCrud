import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Person } from './person';

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  private url = 'rs/person';

  constructor(private http: HttpClient) { }

  findAll() : Observable<Person[]> {

    return this.http.get<Person[]>(this.url);

  }

  findById(id: any) : Observable<Person> {

    return this.http.get<Person>(`${this.url}/${id}`);

  }

  findBySearch(search: any) : Observable<Person> {

    let params = new HttpParams()
    .set('search', search);

    return this.http.get<Person>(this.url, {params});

  }

  post(person: any) : Observable<Person> {

    return this.http.post<Person>(this.url, person);
  }

  put(id: number, person: any) : Observable<Person> {

    return this.http.put<Person>(`${this.url}/${id}`,person);
  }

  delete(id: number) : Observable<void> {
    
    return this.http.delete<void>(`${this.url}/${id}`);
  }
}
