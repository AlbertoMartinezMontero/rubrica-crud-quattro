package it.iad2.service4;

import it.iad2.dto4.ContatoreDto;
import it.iad2.dto4.ListaContattiDto;
import it.iad2.dto4.ContattoDto;
import it.iad2.model4.Contatto;

public interface ServiceQuattro {

    ListaContattiDto conferma(Contatto p);

    ListaContattiDto modifica(Contatto p);
    // OggettoDto annulla (Oggetto p); Da gestire lato client?

    ListaContattiDto rimuovi(Contatto p);

    ContattoDto cerca(String s);
    
    ContattoDto seleziona(Contatto p);
    
    ListaContattiDto aggiornaLista();
    
    ContatoreDto conta();
    

}
