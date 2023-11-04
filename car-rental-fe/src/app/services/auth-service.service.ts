import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, map } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private baseUrl = 'your_backend_api_url';
  isManager: boolean = false;

  constructor(private http: HttpClient, private router: Router) {}

  login(username: string, password: string): Observable<any> {
    const body = { username, password };
    return this.http.post(`${this.baseUrl}/login`, body).pipe(
      map((response: any) => {
        // Assuming your backend response contains user role information
        if (response && response.authorities) {
          this.isManager = response.authorities.some(
            (authority: any) => authority.authority === 'ROLE_MANAGER'
          );
        }
        // Redirect to the appropriate route after successful login
        this.router.navigate(this.isManager ? ['/manager'] : ['/employee']);
        return response;
      }),
      catchError((error: any) => {
        console.log(error);
        alert('Login failed. Please check your credentials.');
        throw error;
      })
    );
  }

  // Implement a logout method if needed

  // Other methods for authentication and user-related actions
}
