package com.example.quizzis;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizzis.PytanieZamkniete;
import com.example.quizzis.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewPytanie;
    private TextView textViewPytanie;
    private RadioGroup radioGroupOdpowiedzi;
    private RadioButton radioOdpowiedz1;
    private RadioButton radioOdpowiedz2;
    private RadioButton radioOdpowiedz3;
    private Button buttonDalej;

    private List<PytanieZamkniete> listaPytan;
    private int aktualnyIndeks;
    private int liczbaPunktow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewPytanie = findViewById(R.id.imageViewPytanie);
        textViewPytanie = findViewById(R.id.textViewPytanie);
        radioGroupOdpowiedzi = findViewById(R.id.radioGroupOdpowiedzi);
        radioOdpowiedz1 = findViewById(R.id.radioOdpowiedz1);
        radioOdpowiedz2 = findViewById(R.id.radioOdpowiedz2);
        radioOdpowiedz3 = findViewById(R.id.radioOdpowiedz3);
        buttonDalej = findViewById(R.id.buttonDalej);

        listaPytan = new ArrayList<>();
        inicjalizujPytania();
        aktualnyIndeks = 0;
        liczbaPunktow = 0;

        wyswietlPytanie();

        buttonDalej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sprawdzIPrzejdzDalej();
            }
        });
    }

    private void inicjalizujPytania() {
        listaPytan.add(new PytanieZamkniete(
                "Które to schronisko?",
                R.drawable.zad1,
                new String[]{"Na Rysiance.", "Na Wielkiej Raczy.", "Na Wielkiej Rycerzowej."},
                1
        ));

        listaPytan.add(new PytanieZamkniete(
                "Zwierzę na zdjęciu to",
                R.drawable.zad2,
                new String[]{"owczarek.", "wilk.", "kozica."},
                0
        ));

        listaPytan.add(new PytanieZamkniete(
                "W oddali są widoczne",
                R.drawable.zad3,
                new String[]{"Himalaje.", "Alpy.", "Tatry."},
                2
        ));
    }

    private void wyswietlPytanie() {
        PytanieZamkniete pytanie = listaPytan.get(aktualnyIndeks);

        imageViewPytanie.setImageResource(pytanie.getIdObrazu());
        textViewPytanie.setText(pytanie.getTresc());

        String[] odpowiedzi = pytanie.getOdpowiedzi();
        radioOdpowiedz1.setText(odpowiedzi[0]);
        radioOdpowiedz2.setText(odpowiedzi[1]);
        radioOdpowiedz3.setText(odpowiedzi[2]);

        radioGroupOdpowiedzi.clearCheck();
    }

    private void sprawdzIPrzejdzDalej() {
        int wybranyId = radioGroupOdpowiedzi.getCheckedRadioButtonId();
        if (wybranyId != -1) {
            int wybranyIndeks = -1;
            if (wybranyId == R.id.radioOdpowiedz1) {
                wybranyIndeks = 0;
            } else if (wybranyId == R.id.radioOdpowiedz2) {
                wybranyIndeks = 1;
            } else if (wybranyId == R.id.radioOdpowiedz3) {
                wybranyIndeks = 2;
            }

            PytanieZamkniete pytanie = listaPytan.get(aktualnyIndeks);
            if (pytanie.sprawdzOdpowiedz(wybranyIndeks)) {
                liczbaPunktow++;
            }
        }

        aktualnyIndeks++;
        if (aktualnyIndeks >= listaPytan.size()) {
            aktualnyIndeks = 0;
        }

        wyswietlPytanie();
    }
}