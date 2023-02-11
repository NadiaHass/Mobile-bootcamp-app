package com.example.mobilebootcamp.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mobilebootcamp.R;
import com.example.mobilebootcamp.models.Lesson;

public class LessonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        Lesson lesson = (Lesson) getIntent().getSerializableExtra("lesson");
    }
}