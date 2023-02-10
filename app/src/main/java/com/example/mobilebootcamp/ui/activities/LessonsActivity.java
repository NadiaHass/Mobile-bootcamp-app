package com.example.mobilebootcamp.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mobilebootcamp.R;
import com.example.mobilebootcamp.models.Lesson;

import java.util.ArrayList;
import java.util.List;

public class LessonsActivity extends AppCompatActivity {
    String[] xmlCodeList ;
    String[] javaCodeList;
    String[] lessonsNameList;
    String[] resultFragmentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);

        List<Lesson> lessons = getLessons(0 , lessonsNameList.length);

        //adapter for recyclerView of lessons
    }

    public ArrayList<Lesson> getLessons(int start , int end){
        ArrayList<Lesson> Lessons = new ArrayList<>();
        for(int i=start ; i<end ; i++){
            Lesson lesson = new Lesson(lessonsNameList[i] , javaCodeList[i] , xmlCodeList[i] ,resultFragmentName[i] );
            Lessons.add(lesson);
        }
        return Lessons;
    }
}