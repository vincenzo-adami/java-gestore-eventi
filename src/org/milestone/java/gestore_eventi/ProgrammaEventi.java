package org.milestone.java.gestore_eventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;

public class ProgrammaEventi {
  private String titolo;
  private List<Evento> eventi;

  ProgrammaEventi(String titolo) {
    this.titolo = titolo;
    this.eventi = new ArrayList<Evento>();
  }

  public String getTitolo() {
    return titolo;
  }

  public void addEvento(Evento e) {
    eventi.add(e);
  }

  public List<Evento> getListaEventiPerData(LocalDate data) {
    List<Evento> listaAiuto = new ArrayList<Evento>();
    for (Evento evento : eventi) {
      if (evento.getData().isEqual(data)) {
        listaAiuto.add(evento);
      }
    }
    return listaAiuto;
  }

  public int getNumeroEventiInProgramma() {
    return this.eventi.size();
  }

  public void emptyEventiInProgramma() {
    this.eventi.clear();
  }

  public String getEventiInProgrammaOrdinati() {
    String risultato = this.titolo + "\n";
    Comparator eventoComparator = new EventoComparator();
    Collections.sort(eventi, eventoComparator);
    for (Evento evento : eventi) {
      risultato += evento.toString() + "\n";
    }
    return risultato;
  }

  @Override
  public String toString() {
    String stampa = titolo + "\n";
    for (Evento evento : eventi) {
      stampa += evento.toString() + "\n";
    }
    return stampa;
  }
}
