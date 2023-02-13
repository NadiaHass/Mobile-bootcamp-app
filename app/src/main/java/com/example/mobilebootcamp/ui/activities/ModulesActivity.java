package com.example.mobilebootcamp.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mobilebootcamp.R;
import com.example.mobilebootcamp.adapters.ModuleAdapter;
import com.example.mobilebootcamp.databinding.ActivityModulesBinding;
import com.example.mobilebootcamp.models.Module;

import java.util.ArrayList;

public class ModulesActivity extends AppCompatActivity {
    private ActivityModulesBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityModulesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ArrayList<Module> modules = new ArrayList<>();
        modules.add(new Module("Widgets" , 0 , 9 , "" , "Customize your Android App with useful and convenient widgets on your home screen"));
        modules.add(new Module("Layouts" , 9 , 15 , "" , "Customize your Android App with useful and convenient widgets on your home screen"));
        modules.add(new Module("Containers" , 15 , 18 , "" , "Customize your Android App with useful and convenient widgets on your home screen"));
        modules.add(new Module("Intent" , 18 , 22 , "" , "Customize your Android App with useful and convenient widgets on your home screen"));
        modules.add(new Module("Menu" , 22 , 26 , "" , "Customize your Android App with useful and convenient widgets on your home screen"));

        ModuleAdapter moduleAdapter = new ModuleAdapter(modules , this);
        binding.rvModules.setLayoutManager(new LinearLayoutManager(this , RecyclerView.VERTICAL , false));
        binding.rvModules.setAdapter(moduleAdapter);

    }

}