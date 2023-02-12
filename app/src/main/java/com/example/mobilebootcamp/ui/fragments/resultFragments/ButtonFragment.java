package com.example.mobilebootcamp.ui.fragments.resultFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.mobilebootcamp.R;

public class ButtonFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_button, container, false);

        TextView textView = (TextView) view.findViewById(R.id.tv_my_text);
        Button button = (Button) view.findViewById(R.id.btn_click_me);

        button.setOnClickListener(v -> textView.setText("You clicked the button !"));

        return view;
    }
}