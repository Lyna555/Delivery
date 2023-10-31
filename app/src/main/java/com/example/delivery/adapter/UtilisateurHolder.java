package com.example.delivery.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.delivery.R;

public class UtilisateurHolder extends RecyclerView.ViewHolder {
    TextView nom_utilisateur, telephone, adresse;
    public UtilisateurHolder(@NonNull View itemView) {
        super(itemView);

        nom_utilisateur = itemView.findViewById(R.id.nom_utilisateur);
        telephone = itemView.findViewById(R.id.telephone);
        adresse = itemView.findViewById(R.id.adresse);
    }
}
