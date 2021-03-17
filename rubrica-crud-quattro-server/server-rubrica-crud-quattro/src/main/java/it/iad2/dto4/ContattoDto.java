package it.iad2.dto4;

import it.iad2.model4.Contatto;

public class ContattoDto {
    public Contatto oggetto;

    public ContattoDto() {
    }

    public ContattoDto(Contatto oggetto) {
        this.oggetto = oggetto;
    }

    public Contatto getOggetto() {
        return oggetto;
    }

    public void setOggetto(Contatto oggetto) {
        this.oggetto = oggetto;
    }

    @Override
    public String toString() {
        return "OggettoDto{" + "oggetto=" + oggetto + '}';
    }
    
     
    
}
