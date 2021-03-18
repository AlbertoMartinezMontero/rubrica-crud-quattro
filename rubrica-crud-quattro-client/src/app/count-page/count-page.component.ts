import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { ContatoreDto } from '../dto/contatore-dto';

@Component({
  selector: 'app-count-page',
  templateUrl: './count-page.component.html',
  styleUrls: ['./count-page.component.css']
})
export class CountPageComponent implements OnInit {

  constructor(private http: HttpClient, private router: Router) { }

  totaleContatti = 0;

  ngOnInit(): void {
    this.conta();
  }

  conta() {
    let oss:Observable<ContatoreDto> = this.http.get<ContatoreDto>("http://localhost:8080/conta");
    oss.subscribe(c => this.totaleContatti = c.totaleContatti);

  }
}
