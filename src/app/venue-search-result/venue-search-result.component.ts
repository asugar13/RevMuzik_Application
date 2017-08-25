import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { SearchResult } from '../classes/search-result';

@Component({
  selector: 'venue-search-result',
  templateUrl: './venue-search-result.component.html',
  styleUrls: ['./venue-search-result.component.scss']
})
export class VenueSearchResultComponent implements OnInit {

	@Input() res: SearchResult;

  constructor(
  		private router: Router
  	) { }

  ngOnInit() {
  }

  viewProfile(result: SearchResult){
  	//consider switching name to id
  	this.router.navigate(['/venue-profile', result.venue.name]);
  }

}
