import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  name = '';
  email = '';
  password = '';
  confirmPassword = '';
  address='';

  constructor(
    private router: Router,
    private customerService: CustomerService) { }

  ngOnInit() {
  }

  onSignup() {
    if (this.name.length == 0) {
      alert('enter  name');
   
    } else if (this.address.length == 0) {
      alert('enter address');
    }
    else if (this.email.length == 0) {
      alert('enter email');
    } else if (this.password.length == 0) {
      alert('enter password');
    } else if (this.confirmPassword.length == 0) {
      alert('confirm password');
    } else if (this.confirmPassword != this.password) {
      alert('password do not match');
    } else {
      this.customerService
        .signup(this.name, this.email, this.password, this.address)
        .subscribe(response => {
          const body = response.json();
          if (body['status'] == 'success') {
            this.router.navigate(['/login']);
          } else {
            alert('error while registering a user');
          }
        });
    }
  }

  onCancel() {
    this.router.navigate(['/login']);
  }

}
