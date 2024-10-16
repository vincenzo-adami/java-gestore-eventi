package org.milestone.java.gestore_eventi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main2 {
  public static void main(String[] args) {

    System.out.println("Inserisci un nuovo concerto");
    Scanner scan = new Scanner(System.in);

    System.out.println("Qual è il titolo dell'concerto?");

    Concerto concerto;
    String titolo = scan.nextLine();

    System.out.println("Inserisci la data dell'concerto\nanno?");
    int anno = scan.nextInt();
    System.out.println("mese?");
    int mese = scan.nextInt();
    System.out.println("giorno?");
    int giorno = scan.nextInt();
    System.out.println("A che ora è il concerto?");
    System.out.println("ore? (es. 00-23)");
    int ora = scan.nextInt();
    System.out.println("minuti? (es. 00-59)");
    int minuti = scan.nextInt();
    System.out.println("Quanto costa il biglietto? (es. xx,xx)");
    double prezzo = 0.00;
    try {
      prezzo = scan.nextDouble();
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage() + "\n Prezzo settato a 0");
    }
    System.err.println("Quanti saranno i posti totali?");
    int postiTotali = scan.nextInt();

    try {
      concerto = new Concerto(titolo, LocalDate.of(anno, mese, giorno), postiTotali, LocalTime.of(ora, minuti), prezzo);

      System.out.println(concerto);

    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    } finally {
      scan.close();
    }

  }
}
