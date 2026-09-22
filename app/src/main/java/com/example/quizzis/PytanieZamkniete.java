package com.example.quizzis;
public class PytanieZamkniete extends Pytanie {
    private String[] odpowiedzi;
    private int indeksPoprawnej;

    public PytanieZamkniete(String tresc, int idObrazu, String[] odpowiedzi, int indeksPoprawnej) {
        super(tresc, idObrazu);
        this.odpowiedzi = odpowiedzi;
        this.indeksPoprawnej = indeksPoprawnej;
    }

    public String[] getOdpowiedzi() {
        return odpowiedzi;
    }

    public int getIndeksPoprawnej() {
        return indeksPoprawnej;
    }

    public boolean sprawdzOdpowiedz(int wybranyIndeks) {
        return wybranyIndeks == indeksPoprawnej;
    }
}
