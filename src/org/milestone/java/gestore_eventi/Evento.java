package org.milestone.java.gestore_eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
  private String titolo;
  private LocalDate data;
  private int postiTotali;
  private int postiPrenotati;

  Evento(String titolo, LocalDate data, int postiTotali) {
    if (!(data.isBefore(LocalDate.now())) && (postiTotali > 0)) {
      this.titolo = titolo;
      setData(data);
      setPostiTotali(postiTotali);
      this.postiPrenotati = 0;
    } else {
      throw new IllegalArgumentException(
          "La data inserito è antecedente ad oggi e/o il numero di posti totali non è maggiore di 0");
    }
  }

  public void setTitolo(String titolo) {
    this.titolo = titolo;
  }

  public String getTitolo() {
    return titolo;
  }

  public void setData(LocalDate data) throws IllegalArgumentException {
    if (!(data.isBefore(LocalDate.now()))) {
      this.data = data;
    } else {
      throw new IllegalArgumentException("La data inserita è antecedente ad oggi");
    }
  }

  public LocalDate getData() {
    return data;
  }

  private void setPostiTotali(int postiTotali) throws IllegalArgumentException {
    if (!(postiTotali <= 0)) {
      this.postiTotali = postiTotali;
    } else {
      throw new IllegalArgumentException("Il numero di posti totali inserito è minore o uguale a 0");
    }
  }

  public int getPostiTotali() {
    return postiTotali;
  }

  public int getPostiPrenotati() {
    return postiPrenotati;
  }

  public void prenota() throws Exception {
    if (!(getData().isBefore(LocalDate.now()) || getPostiPrenotati() >= getPostiTotali())) {
      this.postiPrenotati++;
    } else {
      throw new Exception("L'evento è già avvenuto o non ci sono più posti disponibili");
    }
  }

  public void disdici() throws Exception {
    if (!(getData().isBefore(LocalDate.now()) || getPostiPrenotati() <= 0)) {
      this.postiPrenotati--;
    } else {
      throw new Exception("L'evento è già avvenuto o non ci sono prenotazionio");
    }
  }

  @Override
  public String toString() {
    DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/L/yyyy");
    return data.format(formatoData) + " - " + titolo;
  }
}