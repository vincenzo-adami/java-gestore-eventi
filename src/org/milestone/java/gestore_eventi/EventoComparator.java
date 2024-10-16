package org.milestone.java.gestore_eventi;

import java.util.Comparator;

public class EventoComparator implements Comparator<Evento> {

  @Override
  public int compare(Evento e1, Evento e2) {
    if (e1.getData().isBefore(e2.getData()) && (e1.getTitolo().compareToIgnoreCase(e2.getTitolo()) < 0)) {
      return -1;
    }
    if (e1.getData().isAfter(e2.getData()) && (e1.getTitolo().compareToIgnoreCase(e2.getTitolo()) > 0)) {
      return 1;
    }
    return 0;
  }
}
