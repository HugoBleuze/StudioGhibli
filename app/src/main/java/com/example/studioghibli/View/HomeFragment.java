package com.example.studioghibli.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studioghibli.Controller.MainController;
import com.example.studioghibli.Model.Films;


import com.example.studioghibli.R;
import com.example.studioghibli.View.FilmsAdapter;

import java.util.List;

public class HomeFragment extends Fragment {


    private RecyclerView recyclerView;
    private MainController mainController;

    public HomeFragment() {
        // Required empty public constructor
    }


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = root.findViewById(R.id.RecyclerViewFilms);
        mainController = new MainController(this);
        mainController.onCreate();
        return root;
    }

    public void showList(List<Films> input) {
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter Adapter = new FilmsAdapter(input);
        recyclerView.setAdapter(Adapter);
        Adapter.notifyDataSetChanged();

    }
}