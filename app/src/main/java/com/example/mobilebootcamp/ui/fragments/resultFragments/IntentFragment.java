package com.example.mobilebootcamp.ui.fragments.resultFragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mobilebootcamp.R;
import com.example.mobilebootcamp.R.id;

public class IntentFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_intent, container, false);

        Button button =(Button) view.findViewById(R.id.btn_other_activity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                IntentOtherFragment newFragment = new IntentOtherFragment();
                fragmentTransaction.replace(R.id.fragment_container, newFragment);

                //This will allow the user to navigate back
                // to the current fragment by pressing the back button.
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
        // Inflate the layout for this fragment
        return view ;
    }
}