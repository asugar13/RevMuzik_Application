import { Component, OnInit } from '@angular/core';
import { SearchResult } from '../classes/search-result';
import { SEARCHRESULT } from '../mock-data/mock-search-results';

@Component({
  selector: 'app-results-page',
  templateUrl: './results-page.component.html',
  styleUrls: ['./results-page.component.scss']
})
export class ResultsPageComponent implements OnInit {

  searchQuery: string;
  searchResults: any;
  view: string = 'artist';

  constructor() { 
  	this.searchEvents();
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
  	this.searchResults = SEARCHRESULT;
  }
}
