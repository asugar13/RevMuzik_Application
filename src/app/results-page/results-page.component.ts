import { Component, OnInit } from '@angular/core';
import { SearchResult } from '../classes/search-result';
import { SEARCHRESULT } from '../mock-data/mock-search-results';

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

  constructor(
  	private gigsSvc: GigsService) { 
  	this.searchEvents();

    //call service but data in db isn't enough for testing so put off on that
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
  	//this.searchResults = SEARCHRESULT;
  	this.searchResults = this.gigsSvc.getGigs();
  	console.log("Results from service: ", this.gigsSvc.gigs); 
  }
}
