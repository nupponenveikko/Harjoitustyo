package com.example.htveikkonupponen;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MoveLutemonActivity extends AppCompatActivity {

    Spinner spinnerLutemon, spinnerLocation;
    Button buttonMoveLutemon;
    ArrayList<Lutemon> lutemons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_lutemon);

        spinnerLutemon = findViewById(R.id.spinnerLutemon);
        spinnerLocation = findViewById(R.id.spinnerLocation);
        buttonMoveLutemon = findViewById(R.id.buttonMoveLutemon);

        lutemons = Storage.getInstance().getAllLutemons();

        ArrayList<String> lutemonNames = new ArrayList<>();
        for (Lutemon l : lutemons) {
            lutemonNames.add(l.getId() + ": " + l.getName() + " (" + l.getColor() + ") - " + l.getLocation());
        }

        ArrayAdapter<String> lutemonAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                lutemonNames
        );
        lutemonAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLutemon.setAdapter(lutemonAdapter);

        String[] locations = {"Home", "Training", "Battle"};

        ArrayAdapter<String> locationAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                locations
        );
        locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLocation.setAdapter(locationAdapter);

        buttonMoveLutemon.setOnClickListener(v -> {
            if (lutemons.isEmpty()) {
                Toast.makeText(this, "Create Lutemons first", Toast.LENGTH_SHORT).show();
                return;
            }

            int index = spinnerLutemon.getSelectedItemPosition();
            Lutemon selected = lutemons.get(index);

            String newLocation = spinnerLocation.getSelectedItem().toString();

            Storage.getInstance().moveLutemon(selected.getId(), newLocation);

            Toast.makeText(this, selected.getName() + " moved to " + newLocation, Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}