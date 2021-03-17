package it.iad2.serviceImpl4;

import it.iad2.dto4.ContatoreDto;
import it.iad2.dto4.ListaOggettiDto;
import it.iad2.dto4.OggettoDto;
import it.iad2.model4.Oggetto;
import it.iad2.repository4.RepositoryQuattro;
import it.iad2.service4.ServiceQuattro;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImplQuattro implements ServiceQuattro {

    @Autowired
    RepositoryQuattro repositoryQ;

    @Override
    public ListaOggettiDto conferma(Oggetto p) {
        repositoryQ.save(p);
        ListaOggettiDto dto = new ListaOggettiDto();
        List<Oggetto> listaOggetti = repositoryQ.findAll();
        if (listaOggetti == null) {
            dto.setListaOggetti(new ArrayList<>());
        } else {
            dto.setListaOggetti(listaOggetti);
        }
        return dto;
    }

    @Override
    public ListaOggettiDto rimuovi(Oggetto p) {
        repositoryQ.delete(p);
        ListaOggettiDto dto = new ListaOggettiDto();
        List<Oggetto> listaOggetti = repositoryQ.findAll();

        if (listaOggetti == null) {
            dto.setListaOggetti(new ArrayList<>());
        } else {
            dto.setListaOggetti(listaOggetti);
        }
        return dto;
    }

    @Override
    public ListaOggettiDto modifica(Oggetto p) {
       repositoryQ.save(p);
       return aggiornaLista();
    }

    @Override
    public OggettoDto cerca(String s) {
        OggettoDto dto = new OggettoDto();
        dto.setOggetto(repositoryQ.findByCodice(s));
        return dto;
    }

    @Override
    public ListaOggettiDto aggiornaLista() {
        ListaOggettiDto listaOggettiDto = new ListaOggettiDto();
        List<Oggetto> listaOggetti = repositoryQ.findAll();
        if (listaOggetti == null) {
            listaOggettiDto.setListaOggetti(new ArrayList<>());
        } else {
            listaOggettiDto.setListaOggetti(listaOggetti);
        }
        return listaOggettiDto;
    }

    @Override
    public OggettoDto seleziona(Oggetto p) {
        OggettoDto dto = new OggettoDto();
        repositoryQ.findById(p.getId());
        dto.setOggetto(p);
        return dto;
    }

    @Override
    public ContatoreDto conta() {
        ContatoreDto dto = new ContatoreDto();
        repositoryQ.count();
        return dto;
    }

}
