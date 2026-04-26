package com.example.htveikkonupponen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button buttonCreate, buttonList, buttonMove, buttonTraining, buttonBattle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCreate = findViewById(R.id.buttonCreate);
        buttonList = findViewById(R.id.buttonList);
        buttonMove = findViewById(R.id.buttonMove);
        buttonTraining = findViewById(R.id.buttonTraining);
        buttonBattle = findViewById(R.id.buttonBattle);

        buttonCreate.setOnClickListener(v ->
                startActivity(new Intent(this, CreateLutemonActivity.class)));

        buttonList.setOnClickListener(v ->
                startActivity(new Intent(this, ListLutemonsActivity.class)));

        buttonMove.setOnClickListener(v ->
                startActivity(new Intent(this, MoveLutemonActivity.class)));

        buttonTraining.setOnClickListener(v ->
                startActivity(new Intent(this, TrainingActivity.class)));

        buttonBattle.setOnClickListener(v ->
                startActivity(new Intent(this, BattleActivity.class)));
    }
}