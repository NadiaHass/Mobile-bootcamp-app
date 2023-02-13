package com.example.mobilebootcamp.ui.fragments.resultFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.mobilebootcamp.R;


public class RadioGroupFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_radio_group, container, false);
        RadioGroup radioGroupHr=view.findViewById(R.id.rg_hr);
        RadioButton btn_show=radioGroupHr.findViewById(R.id.btn_show);
        RadioButton btn_hide=radioGroupHr.findViewById(R.id.btn_hide);
        RadioGroup radioGroupVr=view.findViewById(R.id.rg_vr);

        btn_show.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked)
            radioGroupVr.setVisibility(View.VISIBLE);
        });
        btn_hide.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked)
            radioGroupVr.setVisibility(View.INVISIBLE);
        });

        return view;
    }
}