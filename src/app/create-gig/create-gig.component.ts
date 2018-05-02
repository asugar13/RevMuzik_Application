import { Component, OnInit } from '@angular/core';
import { ARTISTS } from '../mock-data/mock-artists';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-create-gig',
  templateUrl: './create-gig.component.html',
  styleUrls: ['./create-gig.component.scss']
})
export class CreateGigComponent implements OnInit {
  
  artists: any = [];
  selectedArtists: any = [];
  urlGigs = 'https://default-environment.vbyhfwx3nw.ca-central-1.elasticbeanstalk.com/api/v1/show/create';

  constructor(private http: HttpClient) { this.getFakeArtists(); }

  ngOnInit() {
  }

  getFakeArtists(){
  	this.artists = ARTISTS;
  }

  addArtist(artist){
  	this.selectedArtists.push(artist);
  }

  removeArtist(index){
  	this.selectedArtists.splice(index, 1);
  }

  newGig(gig){
  	console.log(gig);
  	console.log(this.selectedArtists);

  	return this.http.post(this.urlGigs, gig);
  }

}
