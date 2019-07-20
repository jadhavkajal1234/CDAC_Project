import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email = '';
  password = '';

  constructor(
    private customerService:CustomerService,
    private router: Router) { }

  ngOnInit() {
  }

  onLogin() {
    if (this.email.length == 0) {
      alert('enter email');
    } else if (this.password.length == 0) {
      alert('enter password');
    } else {
      this.customerService
        .login(this.email, this.password)
        .subscribe(response => {
          const body = response.json();
          if (body['status'] == 'success') {

            // cache the login status
            // localStorage
            sessionStorage['login_status'] = '1';

            alert('welcome to the app');
            this.router.navigate(['/home']);
          } else {
            alert(body['error']);
          }
        });
    }
  }

  onCancel() {
    this.router.navigate(['/login']);
  }

  onSignup() {
    this.router.navigate(['/register']);
  }
}
