package com.example.mobilebootcamp.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.mobilebootcamp.R;
import com.example.mobilebootcamp.databinding.ActivityLessonBinding;
import com.example.mobilebootcamp.models.Lesson;
import com.example.mobilebootcamp.ui.fragments.JavaCodeFragment;
import com.example.mobilebootcamp.ui.fragments.XmlCodeFragment;
import com.google.android.material.navigation.NavigationBarView;

public class LessonActivity extends AppCompatActivity {
    private ActivityLessonBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLessonBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Lesson lesson = (Lesson) getIntent().getSerializableExtra("lesson");

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = new Fragment();
            Bundle args = new Bundle();

            switch (item.getItemId()){
                case R.id.java:
                    selectedFragment = new JavaCodeFragment();
                    args.putString("lesson" ,lesson.getJavaCode());
                    break;

                case R.id.xml:
                    selectedFragment = new XmlCodeFragment();
                    args.putString("lesson" , lesson.getXmlCode());
                    break;

                case R.id.result: {
                    try {
                        selectedFragment = (Fragment) (Class.forName("com.example.mobilebootcamp.ui.fragments.resultFragments." + lesson.getResultFragmentName()).newInstance());
                    } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            }
            openSelectedFragment(selectedFragment , args);
            return true;
        });

        if (savedInstanceState == null) {
            binding.bottomNavigation.setSelectedItemId(R.id.java);
        }
    }

    private void openSelectedFragment(Fragment selectedFragment, Bundle args) {
        selectedFragment.setArguments(args);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
    }
}