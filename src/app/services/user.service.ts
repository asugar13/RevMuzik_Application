import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class UserService {

  userURL: any;
  //http options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  constructor(
    private http: HttpClient,
    private router: Router) { this.userURL = 'http://default-environment.vbyhfwx3nw.ca-central-1.elasticbeanstalk.com/api/v1/user/'}

  getUser(user){
  	var url = this.userURL + user; //website.com/user/id
  	
  	return this.http
  		.get(url)
  		.subscribe();
  }

  updateUser(user){
  	return this.http
  		.put('/api/v1/user/update', user);
  }

  createUser(user){
  	console.log("Url is: ", this.userURL + 'create')
    return this.http
  		.post(this.userURL + 'create', user, this.httpOptions)
  		.subscribe(
        res => {
          //SUCCESS
          console.log(res);
          //navigate to results page
          this.router.navigate(['/results']);
        }, error => {
          console.log("Error occured: ", error);
        });
  }

  deleteUser(id){
  	
  	var url = '/api/v1/user/' + id;

  	return this.http
  		.delete(url)
  }
}
