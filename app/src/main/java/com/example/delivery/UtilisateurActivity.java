package com.example.delivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.delivery.adapter.UtilisateurAdapter;
import com.example.delivery.model.Utilisateur;
import com.example.delivery.retrofit.RetrofitService;
import com.example.delivery.retrofit.DeliveryAPI;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UtilisateurActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utilisateur);

        refreshData();

        SwipeRefreshLayout swipeRefreshLayout = findViewById(R.id.layout);
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.white), getResources().getColor(R.color.black));

        swipeRefreshLayout.setOnRefreshListener(() -> {
            refreshData();
            swipeRefreshLayout.setRefreshing(false);
        });
    }

    public void refreshData(){
        RecyclerView recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton floatingActionButton = findViewById(R.id.floating);
        floatingActionButton.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), AddUtilisateur.class);
            startActivity(intent);
        });

        RetrofitService retrofitService = new RetrofitService();
        DeliveryAPI trashAPI = retrofitService.getRetrofit().create(DeliveryAPI.class);
        trashAPI.getAllUtilisateurs().enqueue(new Callback<List<Utilisateur>>() {
            @Override
            public void onResponse(Call<List<Utilisateur>> call, Response<List<Utilisateur>> response) {
                UtilisateurAdapter utilisateurAdapter = new UtilisateurAdapter(response.body());
                recyclerView.setAdapter(utilisateurAdapter);
            }

            @Override
            public void onFailure(Call<List<Utilisateur>> call, Throwable t) {
                Toast.makeText(UtilisateurActivity.this, "Failed to load users!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}