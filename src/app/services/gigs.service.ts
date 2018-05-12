import { Injectable } from '@angular/core';
import { AngularFireDatabase } from 'angularfire2/database';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class GigsService {

	gigs: any;
	urlGigs = 'https://default-environment.vbyhfwx3nw.ca-central-1.elasticbeanstalk.com/api/v1/show';//enter url into browser, hit advanced and proceed 
	newGigsUrl = 'http://default-environment.vbyhfwx3nw.ca-central-1.elasticbeanstalk.com/api/v1/show/create';
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  constructor(
  	private http: HttpClient) { 
  	//this.getGigs();
  }

  getGigs():any{
  	return this.http.get(this.urlGigs);
  }

  newGig(data): any{
  	let stringData = JSON.stringify(data);
    //console.log("Raw data: ", data);
    //console.log("stringified data: ", stringData);

    return this.http.post(this.newGigsUrl, stringData, this.httpOptions)
      .subscribe(res =>{
        console.log("Success");
        //console.log(res);
      }, err => {
        console.log("Error occured: ", err);
      });
  }
}
