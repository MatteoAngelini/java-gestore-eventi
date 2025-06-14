package org.eventi.gestore;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento{
    private LocalTime ora;
    private double prezzo;


    public Concerto(String titolo, LocalDate data, int postiTotali, LocalTime ora, double prezzo) throws IllegalAccessException{
        super(titolo, data, postiTotali);
        this.ora = ora;
        this.prezzo = prezzo;
    }




    public LocalTime getOra() {
        return this.ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public double getPrezzo() {
        return this.prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

//Metodo per ora formattata
public String getOraFormattata(){
    return ora.format(DateTimeFormatter.ofPattern("HH:mm"));
}

// Metodo per prezzo formattato
public String getPrezzoFormattato(){
    DecimalFormat df = new DecimalFormat("€ 00.00");
    return df.format(prezzo);
}



    @Override
    public String toString() {
        return getOraFormattata() + " - " + getTitolo() + " - " + getPrezzoFormattato();
    }

}
