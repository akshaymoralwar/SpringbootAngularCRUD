import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule,importcomponent } from './app-routing.module';
import { AppComponent } from './app.component';


import { HttpModule } from '@angular/http';
import { from } from 'rxjs';
import {FormsModule} from '@angular/forms';
import { HttpserviceService } from './httpservice.service';



@NgModule({
  declarations: [
    AppComponent,
    
    importcomponent,
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpModule,
    FormsModule
  ],
  providers: [HttpserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
