import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Utente } from '../model/utente';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {
  
  utente = new Utente();

  utenteSalvato ="Francesco";
  passwordSalvata ="Filitti";

  constructor(private router : Router) { }



  ngOnInit(): void {
  }

  checkLogin(){
    if(this.utenteSalvato == this.utente.username && this.passwordSalvata == this.utente.password) {
      this.router.navigateByUrl("/homepage");
    } else {
      this.router.navigateByUrl("/error");
    }
    
  }

}
