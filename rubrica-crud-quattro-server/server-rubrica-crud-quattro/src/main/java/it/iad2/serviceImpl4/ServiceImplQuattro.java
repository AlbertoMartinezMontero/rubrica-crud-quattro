package it.iad2.serviceImpl4;

import it.iad2.dto4.ContatoreDto;
import it.iad2.dto4.ListaContattiDto;
import it.iad2.dto4.ContattoDto;
import it.iad2.model4.Contatto;
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
    public ListaContattiDto conferma(Contatto p) {
        repositoryQ.save(p);
        ListaContattiDto dto = new ListaContattiDto();
        List<Contatto> listaOggetti = repositoryQ.findAll();
        if (listaOggetti == null) {
            dto.setListaOggetti(new ArrayList<>());
        } else {
            dto.setListaOggetti(listaOggetti);
        }
        return dto;
    }

    @Override
    public ListaContattiDto rimuovi(Contatto p) {
        repositoryQ.delete(p);
        ListaContattiDto dto = new ListaContattiDto();
        List<Contatto> listaOggetti = repositoryQ.findAll();

        if (listaOggetti == null) {
            dto.setListaOggetti(new ArrayList<>());
        } else {
            dto.setListaOggetti(listaOggetti);
        }
        return dto;
    }

    @Override
    public ListaContattiDto modifica(Contatto p) {
       repositoryQ.save(p);
       return aggiornaLista();
    }

    @Override
    public ContattoDto cerca(String s) {
        ContattoDto dto = new ContattoDto();
        dto.setOggetto(repositoryQ.findByNome(s));
        return dto;
    }

    @Override
    public ListaContattiDto aggiornaLista() {
        ListaContattiDto listaOggettiDto = new ListaContattiDto();
        List<Contatto> listaOggetti = repositoryQ.findAll();
        if (listaOggetti == null) {
            listaOggettiDto.setListaOggetti(new ArrayList<>());
        } else {
            listaOggettiDto.setListaOggetti(listaOggetti);
        }
        return listaOggettiDto;
    }

    @Override
    public ContattoDto seleziona(Contatto p) {
        ContattoDto dto = new ContattoDto();
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
