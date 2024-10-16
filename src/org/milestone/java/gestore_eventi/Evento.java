package org.milestone.java.gestore_eventi;

import java.time.LocalDate;

public class Evento {
  private String titolo;
  private LocalDate data;
  private int postiTotali;
  private int postiPrenotati;

  Evento(String titolo, LocalDate data, int postiTotali) {
    this.titolo = titolo;
    try {
      setData(data);
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
    try {
      setPostiTotali(postiTotali);
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
    this.postiPrenotati = 0;
  }

  public void setTitolo(String titolo) {
    this.titolo = titolo;
  }

  public String getTitolo() {
    return titolo;
  }

  public void setData(LocalDate data) throws Exception {
    if (!(data.isAfter(LocalDate.now()))) {
      this.data = data;
    } else {
      throw new Exception("La data inserita è antecedente ad oggi");
    }
  }

  public LocalDate getData() {
    return data;
  }

  private void setPostiTotali(int postiTotali) throws Exception {
    if (!(postiTotali <= 0)) {
      this.postiTotali = postiTotali;
    } else {
      throw new Exception("Il numero di posti totali inserito è minore o uguale a 0");
    }
  }

  public int getPostiTotali() {
    return postiTotali;
  }

  public int getPostiPrenotati() {
    return postiPrenotati;
  }
}