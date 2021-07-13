package com.example.rexacademy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class comic_show extends AppCompatActivity {

    RecyclerView c_recyclerView;
    comicAdapter adapter;




                @Override
                protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.activity_comic_show);

                    c_recyclerView = (RecyclerView) findViewById(R.id.comic_Recyclerview);
                    c_recyclerView.setLayoutManager(new LinearLayoutManager(this));


                    FirebaseRecyclerOptions<comicModel> options =
                            new FirebaseRecyclerOptions.Builder<comicModel>()
                            .setQuery(FirebaseDatabase.getInstance().getReference().child("Comics"), comicModel.class)
                            .build();

                    adapter = new comicAdapter(options);
                    c_recyclerView.setAdapter(adapter);

                }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}