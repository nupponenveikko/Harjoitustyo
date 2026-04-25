package com.example.htveikkonupponen;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateLutemonActivity extends AppCompatActivity {

    EditText editTextName;
    Spinner spinnerType;
    Button buttonCreateLutemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_lutemon);

        editTextName = findViewById(R.id.editTextName);
        spinnerType = findViewById(R.id.spinnerType);
        buttonCreateLutemon = findViewById(R.id.buttonCreateLutemon);

        String[] types = {"White", "Green", "Pink", "Orange", "Black"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                types
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerType.setAdapter(adapter);

        buttonCreateLutemon.setOnClickListener(v -> {
            String name = editTextName.getText().toString();
            String type = spinnerType.getSelectedItem().toString();

            if (name.isEmpty()) {
                Toast.makeText(this, "Anna nimi", Toast.LENGTH_SHORT).show();
                return;
            }

            Lutemon lutemon;

            switch (type) {
                case "White":
                    lutemon = new White(name);
                    break;
                case "Green":
                    lutemon = new Green(name);
                    break;
                case "Pink":
                    lutemon = new Pink(name);
                    break;
                case "Orange":
                    lutemon = new Orange(name);
                    break;
                default:
                    lutemon = new Black(name);
                    break;
            }

            Storage.getInstance().addLutemon(lutemon);

            Toast.makeText(this, "Lutemon luotu", Toast.LENGTH_SHORT).show();
            editTextName.setText("");
        });
    }
}