package org.milestone.java.gestore_eventi;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.time.DateTimeException;

public class Main {
  public static void main(String[] args) {

    System.out.println("Inserisci un nuovo evento");
    Scanner scan = new Scanner(System.in);
    try {

      System.out.println("Qual è il titolo dell'evento?");

      Evento evento;
      String titolo = scan.nextLine();

      System.out.println("Inserisci la data dell'evento:\nanno?");
      int anno = scan.nextInt();
      System.out.println("mese?");
      int mese = scan.nextInt();
      System.out.println("giorno?");
      int giorno = scan.nextInt();
      System.err.println("Quanti saranno i posti totali?");
      int postiTotali = scan.nextInt();

      evento = new Evento(titolo, LocalDate.of(anno, mese, giorno), postiTotali);

      System.out.println("Vuoi prenotare dei posti all'evento? (es. true se sì altrimenti false)");
      boolean scelta = scan.nextBoolean();
      if (scelta) {
        System.out.println("Quanti posti vuoi prenotare?");
        int posti = scan.nextInt();
        for (int i = 0; i < posti; i++) {
          try {
            evento.prenota();
          } catch (Exception e) {
            System.out.println(e.getMessage());
            break;
          }
        }
      }

      System.out.printf("I posti disponibili per l'evento \"%s\" sono %d su %d\n", evento.getTitolo(),
          (evento.getPostiTotali() - evento.getPostiPrenotati()), evento.getPostiTotali());

      System.out.println("Vuoi disdire dei posti all'evento? (es. true se sì altrimenti false)");
      boolean scelta2 = scan.nextBoolean();
      if (scelta2) {
        System.out.println("Quanti posti vuoi disdire?");
        int posti = scan.nextInt();
        for (int i = 0; i < posti; i++) {
          try {
            evento.disdici();
          } catch (Exception e) {
            System.out.println(e.getMessage());
            break;
          }
        }
      }

      System.out.printf("I posti disponibili per l'evento \"%s\" sono %d su %d\n", evento.getTitolo(),
          (evento.getPostiTotali() - evento.getPostiPrenotati()), evento.getPostiTotali());

    } catch (Exception e) {
      if (e instanceof InputMismatchException) {
        System.err.println("Inserito valore diverso da quanto richiesto");
        return;
      }
      if (e instanceof DateTimeException) {
        System.err.println("I valori della data inseriti non sono possibili: " + e.getMessage());
        return;
      }
      if (e instanceof Exception) {
        System.err.println(e.getMessage());
      }
      e.printStackTrace();
    } finally {
      scan.close();
    }
  }
}
