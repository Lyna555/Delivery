package com.example.delivery.retrofit;

import com.example.delivery.model.Utilisateur;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DeliveryAPI {
    @GET("/utilisateur/get-all")
    Call<List<Utilisateur>> getAllUtilisateurs();

    @POST("/utilisateur/save")
    Call<Utilisateur> save(@Body Utilisateur utilisateur);
}
