import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpserviceService } from '../httpservice.service';

@Component({
  selector: 'app-manager-signup',
  templateUrl: './manager-signup.component.html',
  styleUrls: ['./manager-signup.component.css']
})
export class ManagerSignupComponent implements OnInit {

  constructor(private router:Router,private service:HttpserviceService) { }

  ngOnInit() {
  }

  onSignUp(firstname,lastname,address,dob,contact,organization, email,password){

let signupdata={
  first_name:firstname,
  last_name:lastname,
  dob:dob, 
  address:address,
  mobile:contact,
  organization:organization,
  email:email,
  password:password

};
  console.log(" "+signupdata.first_name);
    this.service.SignUpEMP(signupdata)
    .subscribe(response=>{
      this.router.navigate(['']);
    },error=>{
      alert("Errort Occured!!!!");
    })

  }

}
