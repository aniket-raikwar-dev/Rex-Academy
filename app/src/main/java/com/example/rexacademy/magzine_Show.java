package com.example.rexacademy;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class magzine_Show extends AppCompatActivity {
    RecyclerView m_recyclerView;
    MagAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magzine__show);

        m_recyclerView = (RecyclerView) findViewById(R.id.mag_Recyclerview);
        m_recyclerView.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<magModel> options =
                new FirebaseRecyclerOptions.Builder<magModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Magazine"), magModel.class)
                .build();

        adapter = new MagAdapter(options);
        m_recyclerView.setAdapter(adapter);


    }
}