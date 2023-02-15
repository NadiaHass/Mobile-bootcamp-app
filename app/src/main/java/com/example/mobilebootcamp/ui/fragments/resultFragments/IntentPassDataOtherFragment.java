package com.example.mobilebootcamp.ui.fragments.resultFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mobilebootcamp.R;

public class IntentPassDataOtherFragment extends Fragment {
    TextView dataReceived;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_intent_pass_data_other,
                                        container,
                                        false);
        Bundle bundle = getArguments();
        dataReceived = view.findViewById(R.id.tv_data_received);
        dataReceived.setText("Hello "+bundle.getString("name")+" in this new activity." +
                "\nYour age: "+bundle.getString("age"));

        // Inflate the layout for this fragment
        return view;
    }
}