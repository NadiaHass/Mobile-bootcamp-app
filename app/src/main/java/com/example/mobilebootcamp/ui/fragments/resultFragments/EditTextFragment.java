package com.example.mobilebootcamp.ui.fragments.resultFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mobilebootcamp.R;

public class EditTextFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_text, container, false);

        Button button = view.findViewById(R.id.btn_click);
        TextView textView = view.findViewById(R.id.tv_name);
        EditText editText = view.findViewById(R.id.editText);

        button.setOnClickListener(v -> {
            String name = editText.getText().toString();
            editText.setText("");

            textView.setText(name);
        });
        return view;
    }
}