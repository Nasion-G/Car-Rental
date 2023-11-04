import {Component, OnInit} from '@angular/core';
import {EmployeeService} from "../../services/employee.service";
import {Employee} from "../../models/employee";

@Component({
  selector: 'app-employees',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
   employees: Employee[] ;
  private response: any;
  constructor(private employeeService:EmployeeService) {

  }
  ngOnInit(): void {
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
  isManager(){
    return this.employeeService.isManager().subscribe(
      {
        next:(res:Employee[]):void=>{
          this.employees=res;
          if (this.response.authorities[0].authority==='ROLE_MANAGER'){
            return
          }
        },
        error:err => {
          console.log(err);
          alert("Something went wrong");
        }
      }
    )
  }
}
