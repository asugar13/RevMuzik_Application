import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';

@Injectable()
export class AuthService {

  constructor(private http: Http) { }

  login(val){
  	return this.http
  		.post('/api/v1/login', val)
  		.subscribe();
  }
}
