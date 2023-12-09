package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements RecetteAdapter.OnRecetteClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Recette> listeRecettes = createSampleRecettes();
        RecetteAdapter adapter = new RecetteAdapter(this, listeRecettes, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onRecetteClick(Recette recette) {
        // Répondez au clic de l'utilisateur ici, par exemple, ouvrez une nouvelle activité avec les détails de la recette
        // Cette méthode est appelée depuis l'adaptateur lorsqu'un élément de la liste est cliqué
    }

    private List<Recette> createSampleRecettes() {
        List<Recette> recettes = new ArrayList<>();
        recettes.add(new Recette("Recette 1", "Description de la recette 1"));
        recettes.add(new Recette("Recette 2", "Description de la recette 2"));
        // Ajoutez d'autres recettes
        return recettes;
    }
}
