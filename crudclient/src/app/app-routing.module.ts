import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ManagerLoginComponent } from './manager-login/manager-login.component';
import { ManagerSignupComponent } from './manager-signup/manager-signup.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { HomeScreenComponent } from './home-screen/home-screen.component';

const routes: Routes = [
  {
    path:"",
    component:ManagerLoginComponent
  },
  {
    path:"SignUp",
    component:ManagerSignupComponent
  },
  {
    path:"Home",
    component:HomeScreenComponent
  },
  {
    path:"**",
    component:NotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const importcomponent=[ManagerLoginComponent,
  ManagerSignupComponent,
  NotFoundComponent,HomeScreenComponent];