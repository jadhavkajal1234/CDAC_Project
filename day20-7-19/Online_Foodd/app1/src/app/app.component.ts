import { Component } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
 
  constructor(private router: Router) {

  }


  onLogout() {
    if (sessionStorage['login_status'] == '1') {
      const result = confirm('Are you sure you want to logout?');
      if (result) {
        sessionStorage['login_status'] = '0';
        this.router.navigate(['/login']);
      }
    } else {
      alert('are you kidding me? first login..');
    }
  }
  
}

