import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { CustomerService } from './customer.service';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot([
     
      { path: 'login', component: LoginComponent },
      { path: 'register', component: RegisterComponent },
    ])
  ],
  providers: [
    CustomerService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
