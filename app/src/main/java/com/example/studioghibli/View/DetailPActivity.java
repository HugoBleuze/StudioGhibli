package com.example.studioghibli.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.studioghibli.Controller.DetailController;
import com.example.studioghibli.Controller.DetailPController;
import com.example.studioghibli.R;

import androidx.appcompat.app.AppCompatActivity;


public class DetailPActivity extends AppCompatActivity {
    public DetailPActivity() {}
    private DetailPController detailController;

    public String idPersos = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_p);

        Intent intent = getIntent();
        this.idPersos = intent.getStringExtra(PersosAdapter.Id_Persos);
        detailController = new DetailPController(this);
        detailController.onCreate();
    }

    public void showPDetail(String NameP, String Gender, String Age, String Eye, String Hair) {

        TextView NameTxt = findViewById(R.id.NameP);
        NameTxt.setText(NameP);

        TextView GenderTxt = findViewById(R.id.Gender);
        GenderTxt.setText(Gender);

        TextView AgeTxt = findViewById(R.id.Age);
        AgeTxt.setText(Age);

        TextView EyeTxt = findViewById(R.id.Eye);
        EyeTxt.setText(Eye);

        TextView HairTxt = findViewById(R.id.Hair);
        HairTxt.setText(Hair);

    }
}
