package com.example.mobilebootcamp.ui.fragments.resultFragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.mobilebootcamp.R;

public class IntentUrlFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_intent_url, container, false);
        Button btn =(Button) view.findViewById(R.id.btn_go_to_url);
        EditText url =(EditText) view.findViewById(R.id.ed_url);

        btn.setOnClickListener(view1 -> {
            try {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(String.valueOf(url.getText())));
                startActivity(intent);

            }catch (Exception e){

            }
        });

        return view;
    }
}