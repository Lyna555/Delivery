package com.example.delivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.delivery.model.Utilisateur;
import com.example.delivery.retrofit.DeliveryAPI;
import com.example.delivery.retrofit.RetrofitService;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddUtilisateur extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextInputEditText nom_utilisateur = findViewById(R.id.nom);
        TextInputEditText email = findViewById(R.id.email);
        TextInputEditText adresse = findViewById(R.id.adresse);
        TextInputEditText telephone = findViewById(R.id.telephone);
        TextInputEditText mdps = findViewById(R.id.mdps);

        MaterialButton button = findViewById(R.id.register);

        button.setOnClickListener(view -> {
            String nom_text = nom_utilisateur.getText().toString();
            String email_text = email.getText().toString();
            String adresse_text = adresse.getText().toString();
            String telephone_text = telephone.getText().toString();
            String mdps_text = mdps.getText().toString();

            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setNom_utilisateur(nom_text);
            utilisateur.setAdresse(adresse_text);
            utilisateur.setEmail(email_text);
            utilisateur.setTelephone(telephone_text);
            utilisateur.setMot_de_passe(mdps_text);

            RetrofitService retrofitService = new RetrofitService();
            DeliveryAPI trashAPI = retrofitService.getRetrofit().create(DeliveryAPI.class);

            trashAPI.save(utilisateur).enqueue(new Callback<Utilisateur>() {
                @Override
                public void onResponse(Call<Utilisateur> call, Response<Utilisateur> response) {
                    Toast.makeText(AddUtilisateur.this, "Save Successfull!", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<Utilisateur> call, Throwable t) {
                    Toast.makeText(AddUtilisateur.this, "Save Failed!", Toast.LENGTH_SHORT).show();
                    Logger.getLogger(AddUtilisateur.class.getName()).log(Level.SEVERE, "Error accured", t);
                }
            });
        });
    }
}