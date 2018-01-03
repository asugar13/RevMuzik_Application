import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { SearchResult } from '../classes/search-result';

@Component({
  selector: 'artist-search-result',
  templateUrl: './artist-search-result.component.html',
  styleUrls: ['./artist-search-result.component.scss']
})
export class ArtistSearchResultComponent implements OnInit {
  
  @Input() res: any;
  today: any;

  constructor(
  		private router: Router
  	) { 
        this.today = new Date();
  }

  ngOnInit() {
  }

  viewProfile(result: SearchResult){
  	//consider switching name to id
  	this.router.navigate(['/artist-profile', result.artist.name]);
  }

  //check time, used for checking event status
  checkTime(time: any): boolean{
    
    //debug code
    console.log("Time received: ", time);

    if(time == this.today){
      console.log("Live event");
      return true;
    }else{
      console.log("Event passed or upcoming");
      return false;
    }
    
  }

}
