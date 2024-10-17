package org.milestone.java.gestore_eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
  private String titolo;
  private LocalDate data;
  private int postiTotali;
  private int postiPrenotati;

  Evento(String titolo, LocalDate data, int postiTotali) {
    if ((data.isBefore(LocalDate.now()))) {
      throw new IllegalArgumentException("La data inserito è antecedente ad oggi");
    }
    if (postiTotali <= 0) {
      throw new IllegalArgumentException("Il numero di posti totali non è maggiore di 0");
    }
    this.titolo = titolo;
    setData(data);
    this.postiTotali = postiTotali;
    this.postiPrenotati = 0;
  }

  public void setTitolo(String titolo) {
    this.titolo = titolo;
  }

  public String getTitolo() {
    return titolo;
  }

  public void setData(LocalDate data) throws IllegalArgumentException {
    if ((data.isBefore(LocalDate.now()))) {
      throw new IllegalArgumentException("La data inserita è antecedente ad oggi");
    }
    this.data = data;
  }

  public LocalDate getData() {
    return data;
  }

  public int getPostiTotali() {
    return postiTotali;
  }

  public int getPostiPrenotati() {
    return postiPrenotati;
  }

  public void prenota() throws Exception {
    if ((data.isBefore(LocalDate.now()))) {
      throw new Exception("L'evento è già avvenuto o non ci sono più posti disponibili");
    }
    if (postiPrenotati >= postiTotali) {
      throw new Exception("L'evento non ha più posti disponibili");
    }
    this.postiPrenotati++;
  }

  public void disdici() throws Exception {
    if ((data.isBefore(LocalDate.now()))) {
      throw new Exception("L'evento è già avvenuto");
    }
    if (postiPrenotati <= 0) {
      throw new Exception("L'evento non ha prenotazioni");
    }
    this.postiPrenotati--;
  }

  @Override
  public String toString() {
    DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/L/yyyy");
    return data.format(formatoData) + " - " + titolo;
  }
}