import {Component, OnInit} from '@angular/core';
import {Employee} from "../../models/employee";
import {EmployeeService} from "../../services/employee.service";

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css']
})
export class ManagerComponent implements OnInit{
  employees: Employee;
  constructor(private employeeService:EmployeeService) {

  }

  ngOnInit(): void {

  }

}


