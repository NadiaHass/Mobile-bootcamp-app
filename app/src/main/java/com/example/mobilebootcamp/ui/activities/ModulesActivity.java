package com.example.mobilebootcamp.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

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

        ArrayList<Module> modules = getModules();

        setupRecyclerView(modules);

    }

    private void setupRecyclerView(ArrayList<Module> modules) {
        ModuleAdapter moduleAdapter = new ModuleAdapter(modules , this);
        binding.rvModules.setLayoutManager(new LinearLayoutManager(this , RecyclerView.VERTICAL , false));
        binding.rvModules.setAdapter(moduleAdapter);

    }

    private ArrayList<Module> getModules() {
        ArrayList<Module> modules = new ArrayList<>();
        modules.add(new Module("Widgets" , 0 , 9 , "image1" , "It's an element of a graphical user interface that displays information or provides a way to interact with the os"));
        modules.add(new Module("Layouts" , 9 , 15 , "image2" , "It defines the structure for a user interface in your app"));
        modules.add(new Module("Containers" , 15 , 18 , "image3" , " It's a view that is used to contain other views"));
        modules.add(new Module("Intent" , 18 , 22 , "image4" , " It is mostly used to start activity, send broadcast receiver, start services and send message between two activities"));
        modules.add(new Module("Menu & dialogs" , 22 , 26 , "image5" , "an important part of the UI component which is used to provide some common functionality around the app"));
        modules.add(new Module("Fragments" , 26 , 27 , "image6" , "Customize your Android App with useful and convenient widgets on your home screen"));
        modules.add(new Module("Styles & animation" , 27 , 29 , "image7" , "It's the part of Activity which represents a portion of User Interface(UI) on the screen."));
        modules.add(new Module("Dynamic views" , 29 , 31 , "image8" , "It's the process of adding a motion effect to any view, image, or text"));
        modules.add(new Module("SQLite" , 31 , 32 , "image9" , "when we don't want to have repeating XML code. We create a separate layout and inflate them"));
        modules.add(new Module("Architecture components" , 32 , 34 , "image10" , "It's a new collection of libraries that contains the lifecycle-aware components"));
        modules.add(new Module("Room database" , 34, 35 , "image11" , "It's a part of the Android Architecture Components. It makes it easier to work with SQLiteDatabase"));
        modules.add(new Module("Firebase" , 35 , 37 , "image12" , "It's a Backend-as-a-Service (Baas). It provides developers with a variety of tools and services"));
        return modules;
    }

}