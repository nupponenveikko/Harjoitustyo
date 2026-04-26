package com.example.htveikkonupponen;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class BattleActivity extends AppCompatActivity {

    Spinner spinnerFirst, spinnerSecond;
    Button buttonFight;
    TextView textViewBattleResult;

    ArrayList<Lutemon> lutemons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        Button buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(v -> finish());
        spinnerFirst = findViewById(R.id.spinnerFirst);
        spinnerSecond = findViewById(R.id.spinnerSecond);
        buttonFight = findViewById(R.id.buttonFight);
        textViewBattleResult = findViewById(R.id.textViewBattleResult);

        lutemons = Storage.getInstance().getByLocation("Battle");

        ArrayList<String> names = new ArrayList<>();

        for (Lutemon l : lutemons) {
            names.add(l.getId() + ": " + l.getName() + " (" + l.getColor() + ")");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                names
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerFirst.setAdapter(adapter);
        spinnerSecond.setAdapter(adapter);

        buttonFight.setOnClickListener(v -> {
            if (lutemons.size() < 2) {
                Toast.makeText(this, "Create at least two Lutemons", Toast.LENGTH_SHORT).show();
                return;
            }

            int firstIndex = spinnerFirst.getSelectedItemPosition();
            int secondIndex = spinnerSecond.getSelectedItemPosition();

            if (firstIndex == secondIndex) {
                Toast.makeText(this, "Choose two different Lutemons", Toast.LENGTH_SHORT).show();
                return;
            }

            Lutemon first = lutemons.get(firstIndex);
            Lutemon second = lutemons.get(secondIndex);

            first.resetHealth();
            second.resetHealth();

            BattleField battleField = new BattleField();
            String result = battleField.fight(first, second);

            textViewBattleResult.setText(result);
        });
    }
}