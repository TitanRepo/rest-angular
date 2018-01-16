import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class GuestBookService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get('//localhost:8080/getGuests');
  }

  get(id: string) {
    return this.http.get('//localhost:8080/guestBookEntities/' + id);
  }

  save(guest: any): Observable<any> {
    let result: Observable<Object>;
    if (guest['href']) {
      result = this.http.put(guest.href, guest);
    } else {
      result = this.http.post('//localhost:8080/guestBookEntities/', guest);
    }
    return result;
  }

  remove(href: string) {
    return this.http.delete(href);
  }
}
