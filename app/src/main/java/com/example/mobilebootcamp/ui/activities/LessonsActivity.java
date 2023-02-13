package com.example.mobilebootcamp.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.mobilebootcamp.R;
import com.example.mobilebootcamp.adapters.LessonsAdapter;
import com.example.mobilebootcamp.databinding.ActivityLessonsBinding;
import com.example.mobilebootcamp.models.Lesson;

import java.util.ArrayList;

public class LessonsActivity extends AppCompatActivity {
    String[] xmlCodeList ;
    String[] javaCodeList;
    String[] lessonsNameList;
    String[] resultFragmentName;
    private ActivityLessonsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLessonsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        int start = getIntent().getIntExtra("start" , 0);
        int end = getIntent().getIntExtra("end" , 0);
        String moduleName = getIntent().getStringExtra("name");
        getListsFromStringArray();

        setupRecyclerView(start , end);
    }

    private void setupRecyclerView(int start, int end) {
        ArrayList<Lesson> lessons = getLessons(start , end);
        LessonsAdapter lessonsAdapter = new LessonsAdapter(lessons , this);
        binding.rvLessons.setLayoutManager(new GridLayoutManager(this ,2 , GridLayoutManager.VERTICAL , false));
        binding.rvLessons.setAdapter(lessonsAdapter);
    }

    private void getListsFromStringArray() {
        xmlCodeList = getResources().getStringArray(R.array.xml_code);
        javaCodeList = getResources().getStringArray(R.array.java_code);
        lessonsNameList = getResources().getStringArray(R.array.lessons_name);
        resultFragmentName = getResources().getStringArray(R.array.result_fragment_name);
    }


    public ArrayList<Lesson> getLessons(int start , int end){
        ArrayList<Lesson> Lessons = new ArrayList<>();
        for(int i=start ; i<end ; i++){
            Lesson lesson = new Lesson(lessonsNameList[i],
                    javaCodeList[i],
                    xmlCodeList[i],
                    resultFragmentName[i]);
            Lessons.add(lesson);
        }
        return Lessons;
    }
}