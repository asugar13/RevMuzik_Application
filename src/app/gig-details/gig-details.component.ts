import { Component, OnInit } from '@angular/core';
import { ARTISTRESULT } from '../mock-data/mock-artist-results';

@Component({
  selector: 'app-gig-details',
  templateUrl: './gig-details.component.html',
  styleUrls: ['./gig-details.component.scss']
})
export class GigDetailsComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  getMockArtist(id){
  	return ARTISTRESULT[id];
  }

}
