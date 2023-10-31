package com.example.delivery.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.delivery.R;
import com.example.delivery.model.Utilisateur;

import java.util.List;

public class UtilisateurAdapter extends RecyclerView.Adapter<UtilisateurHolder> {

    private List<Utilisateur> utilisateurList;

    public UtilisateurAdapter(List<Utilisateur> utilisateurList){
        this.utilisateurList = utilisateurList;
    }

    @NonNull
    @Override
    public UtilisateurHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_utilisateur_elem, parent, false);
        return new UtilisateurHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UtilisateurHolder holder, int position) {
        Utilisateur utilisateur = utilisateurList.get(position);
        holder.nom_utilisateur.setText(utilisateur.getNom_utilisateur());
        holder.telephone.setText(utilisateur.getTelephone());
        holder.adresse.setText(utilisateur.getAdresse());
    }

    @Override
    public int getItemCount() {
        return utilisateurList.size();
    }
}
