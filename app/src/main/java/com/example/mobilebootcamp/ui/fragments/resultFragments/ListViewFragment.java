package com.example.mobilebootcamp.ui.fragments.resultFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mobilebootcamp.R;

public class ListViewFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_list_view, container, false);

        String[] languages = {"Java" , "Kotlin" , "C++" , "Python" , "Ruby" , "C#" ,
        "Php" , "Swift" , "Go" , "Pascal" , "Delphi" , "Html" , "Css" , "Sql" , "Matlab"};

        ListView listView = view.findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                requireActivity(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, languages
                );
        listView.setAdapter(adapter);

        return view;
    }
}