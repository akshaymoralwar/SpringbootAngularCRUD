import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

@Injectable({
  providedIn: 'root'
})
export class HttpserviceService {

  

  Baseurl:string="http://localhost:8090/";

  constructor(private http:Http) {   }

  getEMPList(){
   return this.http.get(this.Baseurl+"getAllEmployee");
    
  }

  

  postEmpLogin(logindetails: { email: any; password: any; }){

    // return this.http.get(this.Baseurl+"manager/checkIfExists",logindetails)

    return this.http.post(this.Baseurl+"manager/checkIfExists",logindetails)
  }

  SignUpEMP(signupdetila){

    return this.http.post(this.Baseurl+"manager/saveManager",signupdetila);

  }

  SaveEmployee(empdetails){
    return this.http.post(this.Baseurl+"saveEmployee",empdetails);
  }


  UpdateEMP(updatedata){
    return this.http.put(this.Baseurl+"/updateEmployee/"+updatedata.id,updatedata);
  }

  DeleteEMP(id){
    return this.http.delete(this.Baseurl+"/deleteEmployee/"+id);
  }

}
