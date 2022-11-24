package com.praktikumpbp.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvMovies;
    private ArrayList<Movie> listMovies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listMovies.addAll(MoviesData.getMovies());
        rvMovies = findViewById(R.id.rv_movies);
        rvMovies.setHasFixedSize(true);
        rvMovies.setLayoutManager(new LinearLayoutManager(this));

        //BARU Objek ListMovieAdapter lamda
        ListMovieAdapter listMovieAdapter = new ListMovieAdapter(listMovies, movie -> {
            Intent intent = new Intent(MainActivity.this,MovieDetail.class);

            intent.putExtra("POSTER",movie.getPosterImage());
            intent.putExtra("NAMA_FILM",movie.getTitle());
            intent.putExtra("DESKRIPSI",movie.getDescription());
            intent.putExtra("PRODUCER",movie.getProducer());


            startActivity(intent);
        });

        //LAMA Objek ListMovieAdapter tanpa lamda
//        ListMovieAdapter listMovieAdapter = new ListMovieAdapter(listMovies, new ListMovieAdapter.ItemClickListener() {
//            @Override
//            public void onItemClick(Movie movie) {
//                Intent intent = new Intent(MainActivity.this,MovieDetail.class);
//
//                intent.putExtra("POSTER",movie.getPosterImage());
//                intent.putExtra("NAMA_FILM",movie.getTitle());
//                intent.putExtra("DESKRIPSI",movie.getDescription());
//
//                startActivity(intent);
//            }
//        });
        rvMovies.setAdapter(listMovieAdapter);
    }
}