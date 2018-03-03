import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { LoginComponent } from '../login/login.component';
import { MdDialog } from '@angular/material';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

	isSignedIn: boolean;

  constructor(
  	private auth: AuthService,
  	private dialog: MdDialog) { 
  		this.isSignedIn = false;
  }

  ngOnInit() {
  }

  logIn(){
  	let dialogRef = this.dialog.open(LoginComponent, {
  		height: '400px',
  		width: '600px'
  	});

  	dialogRef.afterClosed().subscribe(res => {
  		console.log(`Dialog result: ${res}`);

  		if(res == true){
  			this.isSignedIn = true;
  		}else{
  			this.isSignedIn = false;
  		}
  	})

	
  }

  signUp(){
  	console.log("Registering new user");
  }

}
