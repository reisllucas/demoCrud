import { Injectable } from '@angular/core';
import {
  Router, Resolve,
  RouterStateSnapshot,
  ActivatedRouteSnapshot
} from '@angular/router';
import { Observable, map, of } from 'rxjs';
import { PersonService } from './person.service';
import { Person } from './person';

@Injectable({
  providedIn: 'root'
})
export class PersonResolver implements Resolve<any> {

  constructor(private _personService: PersonService){}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<any> {
    let response = {}
    if (route.url[0] && route.paramMap.get('id')) {
      return this._personService.findById(route.paramMap.get('id'))
      .pipe(map((p: Person) => {
        return this.resolvePerson(p);
      }))
    } else {
      return this._personService.findAll()
      .pipe(map((pArr: Person[]) => {
        return pArr.map(p => this.resolvePerson(p));
      }))

    }
    
    return of(response);
  }


  resolvePerson(p: Person) {
    if (p.birthDay) {
      let dtStr = p.birthDay.split("-");
      p.birthDay = new Date(dtStr[0],dtStr[1]-1,dtStr[2])
    }
    
    return p;
  }
}
