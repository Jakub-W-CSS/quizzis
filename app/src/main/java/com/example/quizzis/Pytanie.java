package com.example.quizzis;
public class Pytanie {
    private String tresc;
    private int idObrazu;

    public Pytanie(String tresc, int idObrazu) {
        this.tresc = tresc;
        this.idObrazu = idObrazu;
    }

    public String getTresc() {
        return tresc;
    }

    public int getIdObrazu() {
        return idObrazu;
    }
}