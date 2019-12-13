package com.example.studioghibli.View;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studioghibli.Controller.MainPController;
import com.example.studioghibli.Model.Persos;

import com.example.studioghibli.R;
import com.example.studioghibli.View.PersosAdapter;

import java.util.List;

public class DashboardFragment extends Fragment {


    private RecyclerView recyclerView;
    private MainPController mainPController;

    public DashboardFragment() {
        // Required empty public constructor
    }


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        recyclerView = root.findViewById(R.id.RecyclerViewPersos);
        mainPController = new MainPController(this);
        mainPController.onCreate();
        return root;
    }

    public void showListP(List<Persos> input) {
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter Adapter = new PersosAdapter(input);
        recyclerView.setAdapter(Adapter);
        Adapter.notifyDataSetChanged();

    }
}