import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpserviceService } from '../httpservice.service';

@Component({
  selector: 'app-home-screen',
  templateUrl: './home-screen.component.html',
  styleUrls: ['./home-screen.component.css']
})
export class HomeScreenComponent implements OnInit {

  Empdetails=[
    {
    first_name:"Akshata",
    last_name:"Moralwar",
    dob:"02/04/1996",
    city:"Pune",
    address:"Shanivar Peth",
    mobile:8407992827,
    organization:"ptc",
    email:"dsfsad@gmail.com"
  },
  {
    first_name:"Akshata",
    last_name:"Moralwar",
    dob:"02/04/1996",
    city:"Pune",
    address:"Shanivar Peth",
    mobile:8407992827,
    organization:"ptc",
    email:"dsfsad@gmail.com"
  },
  {
    first_name:"Akshata",
    last_name:"Moralwar",
    dob:"02/04/1996",
    city:"Pune",
    address:"Shanivar Peth",
    mobile:8407992827,
    organization:"ptc",
    email:"dsfsad@gmail.com"
  },
  {
    first_name:"Akshata",
    last_name:"Moralwar",
    dob:"02/04/1996",
    city:"Pune",
    address:"Shanivar Peth",
    mobile:8407992827,
    organization:"ptc",
    email:"dsfsad@gmail.com"
  },
];

empDetails=[];
updatemodal:boolean=true;

Email:string="";
City:string="";
Dob:string="";
Address:string="";
Lname:string="";
Fname:string="";
MobileNo:string="";
id:string="";
Org:String="";

  constructor(private router:Router,private service:HttpserviceService) { }

  ngOnInit() {
    this.service.getEMPList()
    .subscribe(response=>{
     console.log(response.json())
      this.empDetails=response.json();
    });
  }

  onSubmit(fname,lname,address,dob,mob,city,email,org){
    let empdetails={
    first_name:fname,
    last_name:lname,
    dob:dob,
    city:city,
    address:address,
    mobile:mob,
    organization:org,
    email:email
    };

    console.log(" "+empdetails);
    this.service.SaveEmployee(empdetails)
    .subscribe(response=>{
      this.router.navigate(['/Home']);
    },error=>{
      alert("Error Occured!!!!");
    })
  }


  onUpdate(item){

    this.updatemodal=false;

    this.Fname=item.first_name;
    this.Lname=item.last_name;
    this.Email=item.email;
    this.Dob=item.dob;
    this.Address=item.address;
    this.City=item.city;
    this.MobileNo=item.mobile;    
    this.id=item.id;
    this.Org=item.organization;

  }

  OnSubmitUpdate(){

    let updatedata={
    first_name:this.Fname,
    last_name:this.Lname,
    dob:this.Dob,
    city:this.City,
    address:this.Address,
    mobile:this.MobileNo,
    id:this.id,
    email:this.Email,
    organization:this.Org     
    };

    this.service.UpdateEMP(updatedata)
    .subscribe(Response=>{
      this.updatemodal=true;
    });


  }

  onDelete(item){

    this.service.DeleteEMP(item.id)
    .subscribe(response=>{
      console.log(response);
      alert("Record Deleted Successfully!!!!");
    });

  }



}
