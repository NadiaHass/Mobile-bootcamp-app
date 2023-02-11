package com.example.mobilebootcamp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilebootcamp.R;
import com.example.mobilebootcamp.models.Lesson;
import com.example.mobilebootcamp.ui.activities.LessonActivity;
import com.example.mobilebootcamp.ui.activities.LessonsActivity;

import java.util.ArrayList;

public class LessonsAdapter extends RecyclerView.Adapter<LessonsAdapter.LessonsViewHolder> {
    ArrayList<Lesson> lessons;
    public Context context;

    public LessonsAdapter(ArrayList<Lesson> lessons , Context context) {
        this.lessons = lessons;
        this.context = context;
    }

    @NonNull
    @Override
    public LessonsAdapter.LessonsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LessonsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.lesson_rv_item , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull LessonsAdapter.LessonsViewHolder holder, int position) {
        holder.lessonName.setText(lessons.get(position).getName());

        holder.itemView.setOnClickListener(v->{
            Intent intent = new Intent((LessonsActivity) context , LessonActivity.class);
            intent.putExtra("lesson" , lessons.get(position));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return lessons.size();
    }

    public static class LessonsViewHolder extends RecyclerView.ViewHolder{
        public TextView lessonName;
        public LessonsViewHolder(@NonNull View itemView) {
            super(itemView);
            lessonName = (TextView) itemView.findViewById(R.id.tv_lesson_item_name);

        }
    }
}
