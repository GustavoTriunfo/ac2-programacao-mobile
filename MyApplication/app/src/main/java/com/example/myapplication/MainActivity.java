package com.example.myapplication;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewFilmes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewFilmes = findViewById(R.id.recyclerViewFilmes);

        List<Filme> filmes = new ArrayList<>();
        filmes.add(new Filme("Sinais", 2002, "Uma família lida com uma invasão alienígena.", "M. Night Shyamalan", R.drawable.sinais));
        filmes.add(new Filme("Guerra dos Mundos", 2005, "A luta pela sobrevivência da humanidade contra alienígenas.", "Steven Spielberg", R.drawable.guerra_mundos));
        filmes.add(new Filme("Invocação do Mal", 2013, "Baseado em eventos reais, um casal investiga fenômenos sobrenaturais.", "James Wan", R.drawable.invocacao));

        FilmeAdapter adapter = new FilmeAdapter(this, filmes);
        recyclerViewFilmes.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewFilmes.setLayoutManager(layoutManager);

        LinearSnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerViewFilmes);
    }
}
