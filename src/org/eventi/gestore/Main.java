package org.eventi.gestore;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Titolo evento: ");
            String titolo = scanner.nextLine();

            System.out.println("Data evento (dd/mm/yyyy): ");
            LocalDate data = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            System.out.println("Numero di posti totali: ");
            int postiTotali = Integer.parseInt(scanner.nextLine());

            Evento evento = new Evento(titolo, data, postiTotali);

            // Prenotazioni
            System.out.println("Vuoi effettuare una prenotazione? ");
            String rispostaPrenota = scanner.nextLine().trim().toLowerCase();
            if (!rispostaPrenota.equals("si")) {
                System.out.println("Nessuna prenotazione effettuata. ");
                System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
                System.out.println("Posti disponbili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));
                return;

            }
            while (true) {
                System.out.println("Quante prenotazioni vuoi fare? ");
                int prenotazioni = Integer.parseInt(scanner.nextLine());
                if (prenotazioni <= (evento.getPostiTotali() - evento.getPostiPrenotati())) {
                    for (int i = 0; i < prenotazioni; i++) {
                        evento.prenota();
                    }
                    break;
                } else {
                    System.out.println("Impossibile prenotare " + prenotazioni + " posti. Disponibili: "
                            + (evento.getPostiTotali() - evento.getPostiPrenotati()));
                    System.out.println("Vuoi riprovare con un numero valido? (si/no): ");
                    if (!scanner.nextLine().trim().toLowerCase().equals("si")) {

                        System.out.println("Nessuna prenotazione effettuata. ");
                        return;
                    }

                }

            }

            System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
            System.out.println("Posti disponbili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));

            // Disdette
            System.out.println("Vuoi effettuare una disdetta? (si/no): ");
            String rispostaDisdici = scanner.nextLine().trim().toLowerCase();
            if (!rispostaDisdici.equals("si")) {
                System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
                System.out.println("Posti disponbili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));
                return;

            }
            while (true) {
                System.out.println("Quante disdette vuoi effettuare? ");
                int disdette = Integer.parseInt(scanner.nextLine());
                if (disdette <= evento.getPostiPrenotati()) {
                    for (int i = 0; i < disdette; i++) {
                        evento.disdici();
                    }
                    break;
                } else {
                    System.out.println("Impossibile disdire " + disdette + " posti. Hai prenotato solo: "
                            + evento.getPostiPrenotati());
                    System.out.println("Vuoi riprovare con un numero valido? (si/no): ");
                    if (!scanner.nextLine().trim().toLowerCase().equals("si")) {
                        System.out.println("Nessuna disdetta effettuata. ");
                        return;

                    }

                }
            }

            System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
            System.out.println("Posti disponbili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));

        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());

        } finally {
            scanner.close();
        }

    }
}
