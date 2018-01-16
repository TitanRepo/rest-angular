import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { GuestBookService } from './shared/guestBook/guest-book.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';


import { AppComponent } from './app.component';
import { GuestBookComponent } from './guest-book/guest-book.component';
import { GuestEditComponent } from './guest-edit/guest-edit.component';

const appRoutes: Routes = [
  { path: '', redirectTo: '/guest-book', pathMatch: 'full' },
  {
    path: 'guest-book',
    component: GuestBookComponent
  },
  {
    path: 'guest-add',
    component: GuestEditComponent
  },
  {
    path: 'guest-edit/:id',
    component: GuestEditComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    GuestBookComponent,
    GuestEditComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [GuestBookService],
  bootstrap: [AppComponent]
})
export class AppModule { }
