package com.example.htveikkonupponen;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TrainingActivity extends AppCompatActivity {

    Spinner spinnerLutemon;
    Button buttonTrain;
    TextView textViewTrainingResult;

    ArrayList<Lutemon> lutemons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        Button buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(v -> finish());
        spinnerLutemon = findViewById(R.id.spinnerLutemon);
        buttonTrain = findViewById(R.id.buttonTrain);
        textViewTrainingResult = findViewById(R.id.textViewTrainingResult);

        lutemons = Storage.getInstance().getByLocation("Training");

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
        spinnerLutemon.setAdapter(adapter);

        buttonTrain.setOnClickListener(v -> {
            if (lutemons.isEmpty()) {
                Toast.makeText(this, "Create Lutemons first", Toast.LENGTH_SHORT).show();
                return;
            }

            int index = spinnerLutemon.getSelectedItemPosition();
            Lutemon selected = lutemons.get(index);

            TrainingArea trainingArea = new TrainingArea();
            trainingArea.train(selected);

            textViewTrainingResult.setText(
                    selected.getName() + " trained!\n\n" + selected.getStats()
            );
        });
    }
}