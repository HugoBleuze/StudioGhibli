package com.example.studioghibli.Controller;

import android.util.Log;

import com.example.studioghibli.Model.API;
import com.example.studioghibli.Model.Films;
import com.example.studioghibli.View.DetailActivity;
import com.example.studioghibli.View.HomeFragment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class DetailController {

    private DetailActivity activity;
    private Gson gson;
    static final String BASE_URL = "https://ghibliapi.herokuapp.com/";

    public DetailController(DetailActivity activity) { this.activity = activity;}

    public void onCreate() {
        gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        API restAPI = retrofit.create(API.class);

        Call<Films> call = restAPI.getDetail(activity.idFilms);

        call.enqueue(new Callback<Films>() {
            @Override
            public void onResponse(Call<Films> call, Response<Films> response) {
                Films restDetailResponse = response.body();
                String Description = restDetailResponse.getDescription();
                String Name = restDetailResponse.getTitle();
                String Director = restDetailResponse.getDirector();
                String Producer = restDetailResponse.getProducer();
                String Date = restDetailResponse.getReleaseDate();
                //appels.....

                activity.showDetail(Description, Name, Director, Producer, Date);

            }

            @Override
            public void onFailure(Call<Films> call, Throwable t) {
                Log.d("ERREUR", call+""+t);
            }
        });

    }
}
