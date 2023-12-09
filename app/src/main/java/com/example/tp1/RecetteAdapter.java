package com.example.tp1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;


import android.content.Intent;


public class RecetteAdapter extends RecyclerView.Adapter<RecetteAdapter.RecetteViewHolder> {

    private List<Recette> listeRecettes;
    private Context context;

    public RecetteAdapter(Context context, List<Recette> listeRecettes, MainActivity mainActivity) {
        this.context = context;
        this.listeRecettes = listeRecettes;
    }

    @NonNull
    @Override
    public RecetteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recette, parent, false);
        return new RecetteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecetteViewHolder holder, int position) {
        Recette recette = listeRecettes.get(position);
        holder.textViewNom.setText(recette.getNom());
        holder.textViewDescription.setText(recette.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Démarrer une nouvelle activité pour afficher la recette complète
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("NOM_RECETTE", recette.getNom());
                intent.putExtra("DESCRIPTION_RECETTE", recette.getDescription());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listeRecettes.size();
    }

    public interface OnRecetteClickListener {
        void onRecetteClick(Recette recette);
    }

    public static class RecetteViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNom;
        TextView textViewDescription;

        public RecetteViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNom = itemView.findViewById(R.id.textViewNom);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
        }
    }
}
