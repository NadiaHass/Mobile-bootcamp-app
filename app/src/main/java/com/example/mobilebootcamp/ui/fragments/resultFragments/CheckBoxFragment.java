package com.example.mobilebootcamp.ui.fragments.resultFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.mobilebootcamp.R;

public class CheckBoxFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_check_box, container, false);

        CheckBox javaCheckBox = view.findViewById(R.id.cb_java);
        CheckBox kotlinCheckBox = view.findViewById(R.id.cb_kotlin);
        TextView textView = view.findViewById(R.id.tv_language_name);
        Button submitButton = view.findViewById(R.id.btn_submit);

        javaCheckBox.setChecked(true);

        submitButton.setOnClickListener(v -> {
            if (javaCheckBox.isChecked() && kotlinCheckBox.isChecked()){
                textView.setText("You checked java and kotlin");
            }else if(javaCheckBox.isChecked()){
                textView.setText("You checked java");
            }else if(kotlinCheckBox.isChecked()){
                textView.setText("You checked kotlin");
            }else{
                textView.setText("You checked nothing !");
            }
        });

        return view;
    }
}