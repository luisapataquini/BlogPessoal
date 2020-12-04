import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../model/User';
import { UserLogin } from '../model/UserLogin';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class AuthService {

  constructor(private http: HttpClient) { }

  cadastrar (user: User): Observable<User> {
    return this.http.post<User>('http://localhost:9000/usuarios/cadastrar', user)
  }

  logar (userLogin: UserLogin): Observable<UserLogin> {
    return this.http.post<UserLogin>('http://localhost:9000/usuarios/logar', userLogin)
  }

  btnSair(){
    let ok = false
    let token = localStorage.getItem('token')

    if (token != null) {
      ok = true
    }

    return ok
  }

  btnLogin() {
    let ok = false
    let token = localStorage.getItem('token')

    if (token == null) {
      ok = true
    }

    return ok
  }

}