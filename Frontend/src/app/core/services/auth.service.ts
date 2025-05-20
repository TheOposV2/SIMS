import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class AuthService {
  private apiUrl = 'http://localhost:8080/api/auth/login'; 

  constructor(private http: HttpClient) {}

login(username: string, password: string) {
  const body = new HttpParams()
    .set('username', username)
    .set('password', password);

  return this.http.post('http://localhost:8080/api/auth/login', body.toString(), {
    headers: new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' }),
    withCredentials: true
  });
}
}
