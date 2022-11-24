package com.praktikumpbp.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieDetail extends AppCompatActivity {
    private ImageView moviePoster;
    private TextView movieTitle,movieDescription, movieProducer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        moviePoster = findViewById(R.id.Poster);
        movieTitle = findViewById(R.id.Title);
        movieDescription = findViewById(R.id.Description);
        movieProducer = findViewById(R.id.Producer);

        int Poster = getIntent().getIntExtra("POSTER",0);
        String judul = getIntent().getStringExtra("NAMA_FILM");
        String deskripsi = getIntent().getStringExtra("DESKRIPSI");
        String producer = getIntent().getStringExtra("PRODUCER");

        moviePoster.setImageResource(Poster);
        movieTitle.setText(judul);
        movieDescription.setText(deskripsi);
        movieProducer.setText(producer);
    }
}