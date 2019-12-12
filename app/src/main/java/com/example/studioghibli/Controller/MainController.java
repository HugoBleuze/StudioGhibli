package com.example.studioghibli.Controller;


import android.util.Log;

import com.example.studioghibli.Model.API;
import com.example.studioghibli.Model.Films;
import com.example.studioghibli.View.HomeFragment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainController {

    private HomeFragment activity;
    private Gson gson;
    static final String BASE_URL = "https://ghibliapi.herokuapp.com/";

    public MainController(HomeFragment activity) { this.activity = activity;}

    public void onCreate() {
        gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        API restAPI = retrofit.create(API.class);

        Call<List<Films>> call = restAPI.getListFilms();

        call.enqueue(new Callback<List<Films>>() {
            @Override
            public void onResponse(Call<List<Films>> call, Response<List<Films>> response) {
                List<Films> restListResponse = response.body();
                activity.showList(restListResponse);
            }

            @Override
            public void onFailure(Call<List<Films>> call, Throwable t) {
                Log.d("ERREUR", call+""+t);
            }
        });

    }
}
