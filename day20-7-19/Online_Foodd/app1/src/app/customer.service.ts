import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions } from '@angular/http';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';

@Injectable()
export class CustomerService implements CanActivate {
  url = 'http://localhost:3000/customer';

  constructor(
    private router: Router,
    private http: Http) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    // check if user has logged in
    if (sessionStorage['login_status'] == '1') {
      return true;
    }

    this.router.navigate(['/login']);
    return false;
  }

  signup(name: string, email: string, password: string,address: string) {
    const body = {
     
      name: name,
      email: email,
      password: password,
      address:address
    };

    const headers = new Headers({'Content-Type': 'application/json'});
    const requestOptions = new RequestOptions({headers: headers});

    return this.http.post(this.url + '/register', body, requestOptions);
  }

  login(email: string, password: string) {
    const body = {
      email: email,
      password: password
    };

    const headers = new Headers({'Content-Type': 'application/json'});
    const requestOptions = new RequestOptions({headers: headers});

    return this.http.post(this.url + '/login', body, requestOptions);
  }

}
