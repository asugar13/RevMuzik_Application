import { Component, OnInit } from '@angular/core';
import { MdDialogRef } from '@angular/material';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  email: any;
  password: any; 

  constructor(
  	public dialogRef: MdDialogRef<LoginComponent>,
  	public authService: AuthService) { }

  ngOnInit() {
  }

  cancel(){
  	this.dialogRef.close(false);
  }

  login(){
  	//call authService if it succeeds then set to true otherwise false
  	this.dialogRef.close(true);
  }

}
