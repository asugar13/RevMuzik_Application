import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-venue-profile',
  templateUrl: './venue-profile.component.html',
  styleUrls: ['./venue-profile.component.scss']
})
export class VenueProfileComponent implements OnInit {

  venueForm: FormGroup;

  constructor(
  	private fb: FormBuilder,
  	private http: HttpClient) { 
  	
  	//form initialize
  	this.venueForm = fb.group({
  		capacity: '',
  		description: '',
  		email: '',
  		equipments: '',
  		hours: '',
  		phoneNumber: '',
  		pictureUrl: '',
  		idStyle: 1,
  		enable: true,
  		url: '',
  		location: '',
  		cc_fips: 1
  	})
  }

  ngOnInit() {
  }

  submit(val){
  	console.log(val);

  	const req = this.http.post('http://revmuzikenv5-env.ca-central-1.elasticbeanstalk.com/api/v1/venue/create', val)
      .subscribe(
        res => {
          console.log(res);
        },
        err => {
          console.log("Error occured");
        }
      );
  }

}
