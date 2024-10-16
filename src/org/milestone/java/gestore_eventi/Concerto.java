package org.milestone.java.gestore_eventi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {
  private LocalTime ora;
  private double prezzo;

  Concerto(String titolo, LocalDate data, int postiTotali, LocalTime ora, double prezzo) {
    super(titolo, data, postiTotali);
    this.ora = ora;
    this.prezzo = prezzo;
  }

  public void setOra(LocalTime ora) {
    this.ora = ora;
  }

  public LocalTime getOra() {
    return ora;
  }

  public void setPrezzo(double prezzo) {
    if (!(prezzo < 0)) {
      this.prezzo = prezzo;
    } else {
      throw new IllegalArgumentException("Il valore inserito è minore di 0");
    }
  }

  public double getPrezzo() {
    return prezzo;
  }

  private String getDataOraFormattate(Concerto c) {
    LocalDateTime dataOra = LocalDateTime.of(c.getData(), c.getOra());
    DateTimeFormatter formatoDataOra = DateTimeFormatter.ofPattern("dd/L/yyyy H:mm");
    return dataOra.format(formatoDataOra);
  }

  private String getPrezzoFormattato(double prezzo) {
    return String.format("%.2f", (prezzo)) + "€";
  }

  @Override
  public String toString() {
    return getDataOraFormattate(this) + " - " + getTitolo() + " - " + getPrezzoFormattato(this.getPrezzo());
  }
}
