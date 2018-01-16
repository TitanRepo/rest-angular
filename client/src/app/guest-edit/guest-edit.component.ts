import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs/Subscription';
import { ActivatedRoute, Router } from '@angular/router';
import { GuestBookService } from '../shared/guestBook/guest-book.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-guest-edit',
  templateUrl: './guest-edit.component.html',
  styleUrls: ['./guest-edit.component.css']
})
export class GuestEditComponent implements OnInit, OnDestroy {

  guest: any = {};
  sub: Subscription;

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }

  constructor(private route: ActivatedRoute,
              private router: Router,
              private guestService: GuestBookService) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.guestService.get(id).subscribe((guest: any) => {
          if (guest) {
            this.guest = guest;
            this.guest.href = guest._links.self.href;
          } else {
            console.log(`Car with id '${id}' not found, returning to list`);
            this.gotoList();
          }
        });
      }
    });
  }

  gotoList() {
    this.router.navigate(['/guest-book']);
  }

  save(form: NgForm) {
    this.guestService.save(form).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }

  remove(href) {
    this.guestService.remove(href).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }
}
