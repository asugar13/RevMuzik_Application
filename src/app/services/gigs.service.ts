import { Injectable } from '@angular/core';
import { AngularFireDatabase } from 'angularfire2/database';

@Injectable()
export class GigsService {

	gigs: any;

  constructor(private db: AngularFireDatabase) { 
  	this.getGigs();
  }

  getGigs(){
  	this.gigs = this.db.list('gigs').snapshotChanges();
  }


}
