import { Component, OnInit } from '@angular/core';
import { MatChipInputEvent } from '@angular/material';
import { ENTER, COMMA } from '@angular/cdk/keycodes';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.scss']
})
export class CreateAccountComponent implements OnInit {
  
  accountType: any = '';
  countries = [
  	{name: 'United States', val: 'US'},
  	{name: 'Canada', val: 'CA'},
  	{name: 'Brazil', val: 'Bra'},
  	{name: 'Mexico', val: 'ME'}
  ];
  states: any = [];

  /////////// MOCK DATA ///////////
  STATES = ['CA', 'CO', 'DA', 'DE', 'FL', 'LA', 'NY', 'TX'];
  CANADA = ['ON', 'BC', 'ED', 'AB', 'QC', 'SK', 'NU', 'YT'];
  BRAZIL = ['MA', 'DF', 'ES', 'GO'];
  MEXICO = ['OA', 'OL', 'MX', 'UR'];

  genres: any = ['blues', 'classical', 'rap', 'deep house', 'dancehall'];

  // Enter, comma
  separatorKeysCodes = [ENTER, COMMA];

  artists: any = []; //for keeping track of user's favourite artists/bands on sign up

  //venue sign up properties
  equipments: any = [];
  hoursWorked: any = [];

  //// form properties
  userFormGroup: FormGroup;

  constructor(private fbuilder: FormBuilder) { }

  ngOnInit() {
    this.userFormGroup = this.fbuilder.group({
      userFirstName: ['', Validators.required],
      userLastName: ['', Validators.required],
      userEmail: ['', Validators.required]
    });
  }

  //displays appropriate sign up form to user based on account types [venue, artist, fan]
  setAccountType(type){
  	this.accountType = type;
  }

  //populates the state select input with the option of the right states to choose from
  setState(country){
  	
  	switch(country){
  		case 'US':
  			this.states = this.STATES;
  			break;
  		case 'CA':
  			this.states = this.CANADA;
  			break;
  		case 'Bra':
  			this.states = this.BRAZIL;
  			break;
  		case 'ME':
  			this.states = this.MEXICO;
  			break;
	  }
  }

  //parses select option from event object to sensible value
  countryChanged(c){
  	//console.log('country selected is', c.source.value);

  	let country = c.source.value;
  	this.setState(country);
  }

  //add artist/band to list of user favourites
  add(event: MatChipInputEvent): void{
  	let input = event.input;
  	let value = event.value;

  	//add artist
  	if((value || '').trim()){
  		this.artists.push({ name: value.trim() });
  	}

  	//reset input value
  	if(input){
  		input.value = '';
  	}
  }

  //remove artist from favourites list
  removeFavourite(artist: any): void{
  	let index = this.artists.indexOf(artist);

  	if(index >= 0)
  		this.artists.splice(index, 1);
  }

  //submit new fan form
  newFan(fan: any): void{
  	console.log("Creating new fan...", fan);
  	console.log("Favourite artists", this.artists);
  }


  //Venue Form Methods
  //

  //add to list of venue equipment
  addEquipment(event: MatChipInputEvent): void{
  	let input = event.input;
  	let value = event.value;

  	//add artist
  	if((value || '').trim()){
  		this.equipments.push({ name: value.trim() });
  	}

  	//reset input value
  	if(input){
  		input.value = '';
  	}
  }

  removeEquipment(equipment: any): void{
  	let index = this.equipments.indexOf(equipment);

  	if(index >= 0)
  		this.equipments.splice(index, 1);
  }

  //for adding new hours to list of working times
  addHours(newHours, startTime, endTime){
  	let newDay = { 
  		day: newHours, 
  		startTime: startTime, 
  		endTime: endTime 
  	};

  	this.hoursWorked.push(newDay);
  }

  //for removing day from hours of operation
  removeDay(day){
  	//console.log(day);

  	this.hoursWorked.splice(day, 1);
  }

  newVenue(venue: any): void{
  	console.log("Creatng new venue", venue);
  }

}
