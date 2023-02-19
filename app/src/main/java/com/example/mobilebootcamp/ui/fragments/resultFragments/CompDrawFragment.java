package com.example.mobilebootcamp.ui.fragments.resultFragments;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobilebootcamp.R;

public class CompDrawFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_drawable_1, container, false);
        AnimationDrawable ad= (AnimationDrawable) view.findViewById(R.id.view_2).getBackground();
        ad.setExitFadeDuration(1000);
        ad.setEnterFadeDuration(1000);
        ad.run();
        return view;
    }
}