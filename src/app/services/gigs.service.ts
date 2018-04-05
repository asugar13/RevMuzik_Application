import { Injectable } from '@angular/core';
import { AngularFireDatabase } from 'angularfire2/database';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class GigsService {

	gigs: any;
	urlGigs = 'http://default-environment.vbyhfwx3nw.ca-central-1.elasticbeanstalk.com/api/v1/show';

  constructor(
  	private http: HttpClient) { 
  	//this.getGigs();
  }

  getGigs():any{
  	return this.http.get(this.urlGigs).subscribe
	  	(res => {
	  		console.log(res);
	  		return res;
	  		//this.gigs = res;
	  	})
  }


}
