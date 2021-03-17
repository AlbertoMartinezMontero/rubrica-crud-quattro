import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Automa } from '../automa/automa';
import { AddEvent, AnnullaEvent, ConfermaEvent, ModificaEvent, RicercaEvent, RimuoviEvent, SelezionaEvent } from '../automa/eventi';
import { Automabile } from '../automa/state';
import { AggiungiState } from '../automa/stati';
import { ContattoDto } from '../dto/contatto-dto';
import { ListaContattiDto } from '../dto/lista-contatti-dto';
import { Contatto } from '../model/contatto';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements Automabile, OnInit {

  contatto: Contatto = new Contatto();
  contatti: Contatto[] = [];
  searchCriterion: string = "";
  automa: Automa;

  // proprietà gui
  buttonNuovaVisible: boolean = false;
  formDivVisible: boolean = false;
  campiNonEditabili: boolean = false;
  confAnnVisible: boolean = false;
  searchVisible: boolean = false;



  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  // TODO: caricare lista prodotti all'inizio
  //this.aggiorna();
  this.automa = new Automa(this);
}

goToAggiungi() {
  this.buttonNuovaVisible = false;
  this.formDivVisible = true;
  this.campiNonEditabili = false;
  this.confAnnVisible = true;
  this.searchVisible = false;
}

goToModifica() {
  this.buttonNuovaVisible = false;
  this.formDivVisible = true;
  this.campiNonEditabili = false;
  this.confAnnVisible = true;
  this.searchVisible = false;
}

goToRicerca() {
  this.buttonNuovaVisible = true;
  this.formDivVisible = false;
  // this.campiNonEditabili = true;
  // this.confAnnVisible = true;
  this.searchVisible = true;
}

goToRimuovi() {
  this.buttonNuovaVisible = false;
  this.formDivVisible = true;
  this.campiNonEditabili = true;
  this.confAnnVisible = true;
  this.searchVisible = false;
}

goToVisualizza() {
  this.buttonNuovaVisible = true;
  this.formDivVisible = true;
  this.campiNonEditabili = true;
  this.confAnnVisible = false;
  this.searchVisible = true;
}

nuova() {
  this.automa.next(new AddEvent());
}

modifica() {
  this.automa.next(new ModificaEvent());
}

conferma() {
  // if (this.automa instanceof AggiungiState){
    let dto: ContattoDto = new ContattoDto();
    dto.contatto = this.contatto;
    let oss: Observable <ListaContattiDto> = this.http.post <ListaContattiDto>('http://localhost:8080/conferma', dto);
    oss.subscribe(c => this.contatti = c.contatti);
    this.contatto = new Contatto();
  // } 
  // this.automa.next(new ConfermaEvent());
}

annulla() {
  this.automa.next(new AnnullaEvent());
}

rimuovi() {
  this.automa.next(new RimuoviEvent());
}

cerca() {
  this.automa.next(new RicercaEvent());
}

seleziona(contatto: Contatto) {
  this.automa.next(new SelezionaEvent());
}

aggiorna() {
  let oss: Observable<Contatto[]> = this.http.get<Contatto[]>('http://localhost:8080/aggiorna');
  oss.subscribe(r => this.contatti = r);
}
}



