package com.example.studioghibli.View;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.studioghibli.Controller.DetailController;
import com.example.studioghibli.R;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    public DetailActivity() {}
    private DetailController detailController;

    public String idFilms = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        this.idFilms = intent.getStringExtra(FilmsAdapter.Id_Films);
        detailController = new DetailController(this);
        detailController.onCreate();
    }

    public void showDetail(String Description, String Name, String Director, String Producer, String Date) {
        TextView TitleTxt = findViewById(R.id.Name);
        TitleTxt.setText(Name);

        TextView DirectorTxt = findViewById(R.id.Director);
        DirectorTxt.setText(Director);

        TextView ProducerTxt = findViewById(R.id.Producer);
        ProducerTxt.setText(Producer);

        TextView DateTxt = findViewById(R.id.Date);
        DateTxt.setText(Date);

        TextView DescriptionTxt = findViewById(R.id.Description);
        DescriptionTxt.setText(Description);


    }
}
