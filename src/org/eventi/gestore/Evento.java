package org.eventi.gestore;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
    private String titolo;
    private LocalDate data;
    private int postiTotali;
    private int postiPrenotati;

    public Evento(String titolo, LocalDate data, int postiTotali) throws IllegalAccessException{
        
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalAccessException("La data dell'evento è già passata.");
        }
        if (postiTotali <= 0) {
            throw new IllegalArgumentException("Il numero di posti totali deve essere positivo");
        }    
            
        this.titolo = titolo;
        this.data = data;
        this.postiTotali = postiTotali;
        this.postiPrenotati = 0;
    }


// Getter e Setter


    public String getTitolo() {
        return titolo;
    }

  
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }


    public LocalDate getData() {
        return data;
    }

 
    public void setData(LocalDate data) {
        this.data = data;
    }

 
    public int getPostiTotali() {
        return postiTotali;
    }

    
    public int getPostiPrenotati() {
        return postiPrenotati;
    }

  //Metodi  
    public void prenota(){
        if (data.isBefore(LocalDate.now())) {
            System.out.println("Impossibile prenotare: l'evento è già passato.");    
        }else if (postiPrenotati >= postiTotali) {
            System.out.println("Impossibile prenotare: non ci sono posti disponibili. Il numero di posti disponibili è " + postiTotali);     
        }else {
            postiPrenotati++;
        }   
    }
    
    public void disdici(){
        if (data.isBefore(LocalDate.now())) {
            System.out.println("Impossibile disdire: l'evento è già passato.");    
        }else if (postiPrenotati >= postiTotali) {
            System.out.println("Impossibile disdire: il numero totale di posti che puoi disdire è " + postiPrenotati);     
        }else {
            postiPrenotati--;
        }
    }


    @Override
    public String toString(){
        return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " - " + titolo;
    }




    


}
