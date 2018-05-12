import { Component, OnInit } from '@angular/core';
import { SearchResult } from '../classes/search-result';
import { SEARCHRESULT } from '../mock-data/mock-search-results';
import { ARTISTRESULT } from '../mock-data/mock-artist-results';

import { GigsService } from '../services/gigs.service';

@Component({
  selector: 'app-results-page',
  templateUrl: './results-page.component.html',
  styleUrls: ['./results-page.component.scss']
})
export class ResultsPageComponent implements OnInit {

  searchQuery: string;
  searchResults: any;
  view: string = 'artist';
  testRes: any;

  constructor(
    private gigsSvc: GigsService) { 
  	  //mock data assignment
      this.searchEvents();

      //this.testGetGig();
  }

  ngOnInit() {
  }

  artistView(){
    this.view = 'artist';
  }

  venueView(){
    this.view = 'venue';
  }

  //move this into service
  searchEvents(){
  	this.testRes = ARTISTRESULT;
  }

  testGetGig(){
    this.gigsSvc.getGigs()
      .subscribe((res) => {
        console.log(res); 
        this.testRes = res;
      });
    //console.log(this.testRes);
  }
}
