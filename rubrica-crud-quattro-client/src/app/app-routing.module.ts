import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CountPageComponent } from './count-page/count-page.component';
import { ErrorPageComponent } from './error-page/error-page.component';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginPageComponent } from './login-page/login-page.component';



const routes: Routes = [
  { path: "", redirectTo: "/login", pathMatch: 'full'},
  { path: "count", component: CountPageComponent},
  { path: "error", component: ErrorPageComponent},
  { path: "login", component: LoginPageComponent},
  { path: "homepage", component: HomepageComponent}
  
];  



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
