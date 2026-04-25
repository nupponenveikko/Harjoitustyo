package com.example.htveikkonupponen;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListLutemonsActivity extends AppCompatActivity {

    RecyclerView recyclerViewLutemons;
    LutemonAdapter adapter;
    ArrayList<Lutemon> lutemons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_lutemons);

        recyclerViewLutemons = findViewById(R.id.recyclerViewLutemons);

        lutemons = Storage.getInstance().getAllLutemons();

        adapter = new LutemonAdapter(lutemons);

        recyclerViewLutemons.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewLutemons.setAdapter(adapter);
    }
}