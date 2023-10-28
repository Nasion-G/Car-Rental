import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {


  private  BASICURL:string='http://localhost:8080';

  constructor( private http : HttpClient) { }

  getAll(){
    return this.http.get(this.BASICURL+'/costumer/all');
  }

  login(body: any, email: string){
    return this.http.post(this.BASICURL+'/costumer/create',body);

  }
}
