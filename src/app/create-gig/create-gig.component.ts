import { Component, OnInit } from '@angular/core';
import { ARTISTS } from '../mock-data/mock-artists';
import { HttpClient } from '@angular/common/http';
import { GigsService } from '../services/gigs.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-create-gig',
  templateUrl: './create-gig.component.html',
  styleUrls: ['./create-gig.component.scss']
})
export class CreateGigComponent implements OnInit {
  
  artists: any = [];
  selectedArtists: any = [];
  urlGigs = 'https://default-environment.vbyhfwx3nw.ca-central-1.elasticbeanstalk.com/api/v1/show/create';
  gigForm: FormGroup;

  constructor(
    private http: HttpClient,
    private gigsSvc: GigsService,
    private fbuilder: FormBuilder) { this.getFakeArtists(); }

  ngOnInit() {
    this.gigForm = this.fbuilder.group({
      name: ['', Validators.required],
      description: ['', Validators.required],
      startDateTime: ['', Validators.required],
      endDateTime: ['', Validators.required],
      imagepath: "imageplaceholder",
      artist: [[{"idartist": 1}]],
      venue: [[{"idvenue": 1}]]
    });
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

  newGig(){
  	//console.log(gig);
  	//console.log(this.selectedArtists);

    let startDate = this.getEpochMillis(this.gigForm.value.startDateTime);
    let endDate = this.getEpochMillis(this.gigForm.value.endDateTime);

    this.gigForm.controls['startDateTime'].setValue(startDate);
    this.gigForm.controls['endDateTime'].setValue(endDate);
    this.gigForm.controls['artist'].setValue(this.selectedArtists);

    console.log(this.gigForm.value);

  	this.gigsSvc.newGig(this.gigForm.value);
  }

  getEpochMillis(dateStr) {
    return Date.parse(dateStr);
  };

}
