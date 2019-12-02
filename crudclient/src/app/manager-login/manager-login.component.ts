import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpserviceService } from '../httpservice.service';

@Component({
  selector: 'app-manager-login',
  templateUrl: './manager-login.component.html',
  styleUrls: ['./manager-login.component.css']
})
export class ManagerLoginComponent implements OnInit {

  constructor(private router:Router,private service:HttpserviceService) { }

  ngOnInit() {
  }

  onSignup(){

    this.router.navigate(["/SignUp"]);
  }
  onLogin(Email,Password){
console.log("Email Id "+Email);
console.log("Password "+Password);
    let createdata={
      email:Email,
      password:Password
    };

    this.service.postEmpLogin(createdata)
    .subscribe(response=>{
      console.log(response);
      
      this.router.navigate(['/Home']);
    },error=>{
      alert("Error Occured!!!");
     // this.router.navigate(['/Home']);
    })
  }

}
