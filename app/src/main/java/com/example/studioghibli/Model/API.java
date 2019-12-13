package com.example.studioghibli.Model;

import com.example.studioghibli.Model.Films;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface API {

    @GET("films")
    Call<List<Films>> getListFilms();

    @GET("people")
    Call<List<Persos>> getListPersos();

}