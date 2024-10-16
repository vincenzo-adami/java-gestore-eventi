package org.milestone.java.gestore_eventi;

import java.time.LocalDate;
import java.util.List;

public class Main3 {
  public static void main(String[] args) {
    Evento e1 = new Evento("titolo1", LocalDate.of(2025, 12, 15), 20);
    Evento e2 = new Evento("titolo2", LocalDate.of(2025, 12, 10), 20);
    Evento e3 = new Evento("titolo3", LocalDate.of(2025, 12, 20), 20);
    Evento e4 = new Evento("titolo4", LocalDate.of(2025, 12, 20), 20);
    Evento e5 = new Evento("titolo5", LocalDate.of(2025, 12, 20), 20);
    Evento e6 = new Evento("titolo6", LocalDate.of(2025, 12, 20), 20);

    ProgrammaEventi proEve1 = new ProgrammaEventi("Titolo programma");

    proEve1.addEvento(e1);
    proEve1.addEvento(e2);
    proEve1.addEvento(e3);
    proEve1.addEvento(e4);
    proEve1.addEvento(e5);
    proEve1.addEvento(e6);

    System.out.println(proEve1);

    System.out.println(
        "In data 20/12/2025 ci sono questi eventi:\n" + proEve1.getListaEventiPerData(LocalDate.of(2025, 12, 20)));

    System.out.printf("Nell programma %s sono presenti %d eventi\n", proEve1.getTitolo(),
        proEve1.getNumeroEventiInProgramma());

    String elencoProgrammaOrdinato = proEve1.getEventiInProgrammaOrdinati();

    System.out.println("Elenco progamma ordinato per data:\n" + elencoProgrammaOrdinato);

    proEve1.emptyEventiInProgramma();

    System.out.println("Lista programma vuota\n" + proEve1);

  }

}
