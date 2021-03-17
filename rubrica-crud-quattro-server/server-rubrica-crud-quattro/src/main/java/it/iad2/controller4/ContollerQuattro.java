package it.iad2.controller4;

import it.iad2.dto4.ContatoreDto;
import it.iad2.dto4.ListaContattiDto;
import it.iad2.dto4.ContattoDto;
import it.iad2.dto4.StringaDto;
import it.iad2.service4.ServiceQuattro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ContollerQuattro {

    @Autowired
    ServiceQuattro servizio;

    @ResponseBody
    @RequestMapping("/conferma")
    public ListaContattiDto conferma(@RequestBody ContattoDto dto) {
        return servizio.conferma(dto.getOggetto());
    }

    @ResponseBody
    @RequestMapping("/rimuovi")
    public ListaContattiDto rimuovi(@RequestBody ContattoDto dto) {
        return servizio.rimuovi(dto.getOggetto());
    }

    @ResponseBody
    @RequestMapping("/modifica")
    public ListaContattiDto modifica(@RequestBody ContattoDto dto) {
        return servizio.modifica(dto.getOggetto());
    }

    /*@ResponseBody
    @RequestMapping("/cerca")
    public ContattoDto cerca(@RequestBody StringaDto dto) {
        return servizio.cerca(dto.getCriterio());
    }*/

    @ResponseBody
    @RequestMapping("/aggiorna")
    public ListaContattiDto aggiornaLista() {
        return servizio.aggiornaLista();
    }
    
    @ResponseBody
    @RequestMapping("/conta")
    public ContatoreDto conta() {
        return servizio.conta();
    }
}
