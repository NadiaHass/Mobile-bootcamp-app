package com.example.mobilebootcamp.ui.fragments.resultFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mobilebootcamp.R;
import com.example.mobilebootcamp.ui.fragments.additional.Fragment1;
import com.example.mobilebootcamp.ui.fragments.additional.Fragment2;

public class FragmentsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragments, container, false);

        Button button1 = view.findViewById(R.id.btn_fragment1);
        Button button2 = view.findViewById(R.id.btn_fragment2);

        button1.setOnClickListener(v -> {
            Fragment fragment1 = new Fragment1();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();

        });

        button2.setOnClickListener(v -> {
            Fragment fragment2 = new Fragment2();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment2).commit();

        });

        return view;
    }
}