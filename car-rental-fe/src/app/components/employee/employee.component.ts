import {Component, OnInit} from '@angular/core';
import {EmployeeService} from "../../services/employee.service";
import {Employee} from "../../models/employee";
import { AuthService } from 'src/app/services/auth-service.service';

@Component({
  selector: 'app-employees',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
   employees: Employee[] ;
   isManager: boolean = false;
   constructor(private employeeService: EmployeeService, private authService: AuthService) {}
  ngOnInit(): void {
    this.isManager = this.authService.isManager;
    this.getAll();
  }

  getAll(){
    return this.employeeService.getAll().subscribe(
      {
        next:(res:Employee[]):void=>{
          this.employees=res;
        },
        error:err => {
          console.log(err);
          alert("Something went wrong");
        }
      }
    );
  }
}
