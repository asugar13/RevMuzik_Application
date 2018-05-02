import { Injectable } from '@angular/core';
import { AngularFireDatabase } from 'angularfire2/database';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class GigsService {

	gigs: any;
	urlGigs = 'https://default-environment.vbyhfwx3nw.ca-central-1.elasticbeanstalk.com/api/v1/show';//enter url into browser, hit advanced and proceed 
	newGigsUrl = 'https://default-environment.vbyhfwx3nw.ca-central-1.elasticbeanstalk.com/api/v1/show/create';

  constructor(
  	private http: HttpClient) { 
  	//this.getGigs();
  }

  getGigs():any{
  	return this.http.get(this.urlGigs);
  }

  newGig(data): any{
  	//return this.http.post(data, this.newGigsUrl);
  }
}
