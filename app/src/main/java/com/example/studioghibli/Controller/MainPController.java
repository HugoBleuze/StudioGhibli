package com.example.studioghibli.Controller;



import android.util.Log;

import com.example.studioghibli.Model.API;
import com.example.studioghibli.Model.Films;
import com.example.studioghibli.Model.Persos;
import com.example.studioghibli.View.DashboardFragment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainPController {

    private DashboardFragment activity;
    private Gson gson;
    static final String BASE_URL = "https://ghibliapi.herokuapp.com/";

    public MainPController(DashboardFragment activity) { this.activity = activity;}

    public void onCreate() {
        gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        API restAPI = retrofit.create(API.class);

        Call<List<Persos>> call = restAPI.getListPersos();

        call.enqueue(new Callback<List<Persos>>() {
            @Override
            public void onResponse(Call<List<Persos>> call, Response<List<Persos>> response) {
                List<Persos> restListResponse = response.body();
                activity.showListP(restListResponse);
            }

            @Override
            public void onFailure(Call<List<Persos>> call, Throwable t) {
                Log.d("ERREUR", call+""+t);
            }
        });

    }
}
