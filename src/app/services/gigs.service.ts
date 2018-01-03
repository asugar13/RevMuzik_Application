import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';	

@Injectable()
export class GigsService {

	gigs: any;
	showsUrl = "http://localhost:8080/api/v1/show";

  constructor(
  	private http: HttpClient) { 
  		//this.getGigs();
  }


  getGigs(){
  	return this.http.get(this.showsUrl);
  }


}
