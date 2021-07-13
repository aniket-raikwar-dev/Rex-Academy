package com.example.rexacademy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.net.HttpCookie;

public class book_show extends AppCompatActivity {

    RecyclerView bookRecylerview;
    showBookAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_show);

        bookRecylerview = (RecyclerView) findViewById(R.id.book_RecyclerView);
        bookRecylerview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<bookModel> options =
                new FirebaseRecyclerOptions.Builder<bookModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Books"), bookModel.class)
                .build();

        adapter = new showBookAdapter(options);
        bookRecylerview.setAdapter(adapter);



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