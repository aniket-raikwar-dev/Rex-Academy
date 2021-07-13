package com.example.rexacademy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class video_show extends AppCompatActivity {

    RecyclerView recview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_show);

        recview = (RecyclerView) findViewById(R.id.video_RecyclerView);

        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<fileModel> options =
                new FirebaseRecyclerOptions.Builder<fileModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Videos"), fileModel.class)
                .build();

        FirebaseRecyclerAdapter<fileModel, myviewholder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<fileModel, myviewholder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull fileModel model) {

                holder.prepareExoplayer(getApplication(), model.getTitle(), model.getVurl());

            }

            @NonNull
            @Override
            public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow, parent, false);
                return new myviewholder(view);
            }
        };

        firebaseRecyclerAdapter.startListening();
        recview.setAdapter(firebaseRecyclerAdapter);



    }
}