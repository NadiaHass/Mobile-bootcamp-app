package com.example.mobilebootcamp.ui.fragments.resultFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobilebootcamp.R;
import com.example.mobilebootcamp.adapters.LanguagesAdapter;

import java.util.ArrayList;


public class RecyclerViewFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        ArrayList<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("Kotlin");
        languages.add("C++");
        languages.add("Python");
        languages.add("Ruby");
        languages.add("C#");
        languages.add("Php");
        languages.add("Swift");
        languages.add("Go");
        languages.add("Pascal");
        languages.add("Delphi");


        RecyclerView recyclerView = view.findViewById(R.id.rv_languages);
        LanguagesAdapter languagesAdapter = new LanguagesAdapter(languages);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity() , RecyclerView.VERTICAL , false));
        recyclerView.setAdapter(languagesAdapter);
        return view;
    }
}