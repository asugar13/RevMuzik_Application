import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';

@Injectable()
export class UserService {

  constructor(private http: Http) { }

  getUser(user){
  	var url = '/api/v1/user/' + user;
  	
  	return this.http
  		.get(url)
  		.subscribe();
  }

  updateUser(user){
  	return this.http
  		.put('/api/v1/user/update', user);
  }

  createUser(user){
  	return this.http
  		.post('/api/v1/user/create', user)
  		.subscribe();
  }

  deleteUser(id){
  	
  	var url = '/api/v1/user/' + id;

  	return this.http
  		.delete(url)
  }
}
