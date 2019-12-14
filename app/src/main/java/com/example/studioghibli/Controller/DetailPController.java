package com.example.studioghibli.Controller;


import android.util.Log;

import com.example.studioghibli.Model.API;
import com.example.studioghibli.Model.Films;
import com.example.studioghibli.Model.Persos;
import com.example.studioghibli.View.DetailActivity;
import com.example.studioghibli.View.DetailPActivity;
import com.example.studioghibli.View.HomeFragment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class DetailPController {
    private DetailPActivity activity;
    private Gson gson;
    static final String BASE_URL = "https://ghibliapi.herokuapp.com/";

    public DetailPController(DetailPActivity activity) { this.activity = activity;}

    public void onCreate() {
        gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        API restAPI = retrofit.create(API.class);

        Call<Persos> call = restAPI.getPDetail(activity.idPersos);

        call.enqueue(new Callback<Persos>() {
            @Override
            public void onResponse(Call<Persos> call, Response<Persos> response) {
                Persos restDetailResponse = response.body();

                String Name = restDetailResponse.getName();
                String Gender = restDetailResponse.getGender();
                String Age = restDetailResponse.getAge();
                String Eye = restDetailResponse.getEyeColor();
                String Hair = restDetailResponse.getHairColor();

                activity.showPDetail(Name, Gender, Age, Eye, Hair);

            }

            @Override
            public void onFailure(Call<Persos> call, Throwable t) {
                Log.d("ERREUR", call+""+t);
            }
        });

    }
}
