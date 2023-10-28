import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {EmployeeService} from "../../services/employee.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  username:string;
  password:string;
  constructor(private router:Router,
              private employeeService:EmployeeService) {
  }
  ngOnInit(): void {
  }

  onLogin(){
    this.employeeService.login(this.username, this.password).subscribe({
      next: ()=> {
        this.createSession();
        this.router.navigate(['/employees'])
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
    sessionStorage.setItem('auth', 'Basic ' + window.btoa(this.username + ':' + this.password))
  }
}
