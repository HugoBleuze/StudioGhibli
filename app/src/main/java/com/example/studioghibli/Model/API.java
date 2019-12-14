package com.example.studioghibli.Model;

import com.example.studioghibli.Model.Films;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface API {

    @GET("films")
    Call<List<Films>> getListFilms();

    @GET("films/{id}")
    Call<Films> getDetail(@Path("id") String id);

    @GET("people")
    Call<List<Persos>> getListPersos();

    @GET("people/{id}")
    Call<Persos> getPDetail(@Path("id") String id);
}