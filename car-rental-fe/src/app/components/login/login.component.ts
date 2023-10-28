import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {EmployeeService} from "../../services/employee.service";
import {CustomerService} from "../../services/customer.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  name:string;
  email:string;
  constructor(private router:Router,
              private customerService:CustomerService) {
  }
  ngOnInit(): void {
  }

  onLogin(){
    this.customerService.login(this.name, this.email).subscribe({
      next: ()=> {
        this.createSession();
        this.router.navigate(['/customers'])
      },
      error: err=> {
        if (err.status === 403)
          alert(err.error);
        else
          alert("Username or password invalid")
      }
    });
  }

  createSession(){
    sessionStorage.setItem('auth', 'Basic ' + window.btoa(this.name + ':' + this.email))
  }

  protected protectedName = name;
}
