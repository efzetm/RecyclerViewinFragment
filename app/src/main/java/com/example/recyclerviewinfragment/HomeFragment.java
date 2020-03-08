package com.example.recyclerviewinfragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private RecyclerView rvHero;
    private ArrayList<HeroesModel> listHero  = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rvHero = view.findViewById(R.id.rv_hero);
        rvHero.setHasFixedSize(true);
        showRecyclerList();
        return view;
    }

    private void showRecyclerList() {

        HeroesAdapter listHeroesAdapater = new HeroesAdapter(HeroesData.getHeroList(),getContext());
        rvHero.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvHero.setAdapter(listHeroesAdapater);

    }

}
