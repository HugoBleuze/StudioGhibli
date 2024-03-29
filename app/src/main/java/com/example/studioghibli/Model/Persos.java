package com.example.studioghibli.Model;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Persos {

    private String id;
    private String name;
    private String gender;
    private String age;
    private String eye_color;
    private String hair_color;
    private List<String> films = null;
    private String species;
    private String url;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEyeColor() {
        return eye_color;
    }

    public void setEyeColor(String eyeColor) {
        this.eye_color = eye_color;
    }

    public String getHairColor() {
        return hair_color;
    }

    public void setHairColor(String hairColor) {
        this.hair_color = hair_color;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}


