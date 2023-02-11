package com.example.mobilebootcamp.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mobilebootcamp.R;
import com.example.mobilebootcamp.databinding.ActivityModulesBinding;

public class ModulesActivity extends AppCompatActivity {
    private ActivityModulesBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityModulesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnWidgets.setOnClickListener(v -> {
            openLessonsActivity(0 , 1);
        });

        binding.btnLayouts.setOnClickListener(v->{

        });

    }

    private void openLessonsActivity(int start, int end) {
        Intent intent = new Intent(this , LessonsActivity.class);
        intent.putExtra("start" , start);
        intent.putExtra("end" , end);
        startActivity(intent);
    }


}