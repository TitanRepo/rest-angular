import { Component, OnInit } from '@angular/core';
import { GuestBookService } from '../shared/guestBook/guest-book.service';

@Component({
  selector: 'app-guest-book',
  templateUrl: './guest-book.component.html',
  styleUrls: ['./guest-book.component.css']
})
export class GuestBookComponent implements OnInit {

  guests: Array<any>;

  constructor(private guestService: GuestBookService) { }

  ngOnInit() {
    this.guestService.getAll().subscribe(data => {
      this.guests = data;
    });
  }

}
