package com.example.htveikkonupponen;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Button;
import java.util.ArrayList;

public class ListLutemonsActivity extends AppCompatActivity {

    RecyclerView recyclerViewLutemons;
    LutemonAdapter adapter;
    ArrayList<Lutemon> lutemons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_lutemons);
        Button buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(v -> finish());
        recyclerViewLutemons = findViewById(R.id.recyclerViewLutemons);

        lutemons = Storage.getInstance().getAllLutemons();

        adapter = new LutemonAdapter(lutemons);

        recyclerViewLutemons.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewLutemons.setAdapter(adapter);
    }
}