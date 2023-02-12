package com.example.mobilebootcamp.ui.fragments.resultFragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.example.mobilebootcamp.R;
public class RadioButtonFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_radio_button, container, false);

        RadioButton redRadioButton = view.findViewById(R.id.rb_red);
        Button submitButton = view.findViewById(R.id.btn_submit);
        LinearLayout layout = view.findViewById(R.id.linearLayout);

        submitButton.setOnClickListener(v -> {
            if (redRadioButton.isChecked()){
                layout.setBackgroundColor(Color.RED);
                redRadioButton.setChecked(false);
            }else{
                layout.setBackgroundColor(Color.WHITE);
            }
        });
        return view;
    }
}