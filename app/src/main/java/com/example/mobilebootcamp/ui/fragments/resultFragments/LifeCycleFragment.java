package com.example.mobilebootcamp.ui.fragments.resultFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mobilebootcamp.R;

public class LifeCycleFragment extends Fragment {
    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(requireContext() , "onStart called" , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(requireContext() , "onResume called" , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(requireContext() , "onPause called" , Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(requireContext() , "onStop called" , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(requireContext() , "onDestroy called" , Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_life_cycle, container, false);
    }
}