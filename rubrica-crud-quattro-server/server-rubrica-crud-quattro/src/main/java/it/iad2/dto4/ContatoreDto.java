package it.iad2.dto4;

public class ContatoreDto {
    private int totaleContatti;

    public ContatoreDto() {
    }

    public ContatoreDto(int totaleContatti) {
        this.totaleContatti = totaleContatti;
    }

    public int getTotaleContatti() {
        return totaleContatti;
    }

    public void setTotaleContatti(int totaleContatti) {
        this.totaleContatti = totaleContatti;
    }
    
}
