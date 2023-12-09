package com.example.tp1;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView textViewNom = findViewById(R.id.textViewNomDetail);
        TextView textViewDescription = findViewById(R.id.textViewDescriptionDetail);

        // Récupérez les données de l'intent
        String nomRecette = getIntent().getStringExtra("NOM_RECETTE");
        String descriptionRecette = getIntent().getStringExtra("DESCRIPTION_RECETTE");

        // Affichez les données dans les TextView
        textViewNom.setText(nomRecette);
        textViewDescription.setText(descriptionRecette);
    }
}

