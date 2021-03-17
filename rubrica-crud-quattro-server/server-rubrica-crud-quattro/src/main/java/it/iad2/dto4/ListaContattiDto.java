package it.iad2.dto4;

import it.iad2.model4.Contatto;
import java.util.List;

public class ListaContattiDto {

    public List<Contatto> listaOggetti;

    public ListaContattiDto() {
    }

    public ListaContattiDto(List<Contatto> listaOggetti) {
        this.listaOggetti = listaOggetti;
    }

    public List<Contatto> getListaOggetti() {
        return listaOggetti;
    }

    public void setListaOggetti(List<Contatto> listaOggetti) {
        this.listaOggetti = listaOggetti;
    }

}
