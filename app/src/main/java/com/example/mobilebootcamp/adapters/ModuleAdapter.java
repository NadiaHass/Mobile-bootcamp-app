package com.example.mobilebootcamp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mobilebootcamp.R;
import com.example.mobilebootcamp.models.Module;
import com.example.mobilebootcamp.ui.activities.LessonsActivity;

import java.util.ArrayList;

public class ModuleAdapter  extends RecyclerView.Adapter<ModuleAdapter.ModulesViewHolder> {
    ArrayList<Module> modules;
    public Context context;

    public ModuleAdapter(ArrayList<Module> modules , Context context) {
        this.modules = modules;
        this.context = context;
    }

    @NonNull
    @Override
    public ModuleAdapter.ModulesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ModuleAdapter.ModulesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.module_rv_item , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull ModulesViewHolder holder, int position) {
        holder.moduleName.setText(modules.get(position).getName());
        holder.description.setText(modules.get(position).getDescription());
        holder.itemView.setOnClickListener(v->{
            Module module = modules.get(position);
            openLessonsActivity(module.getStartLesson() , module.getEndLesson() , module.getName());
        });
                Glide.with(context)
                .load(context.getResources().getIdentifier(modules.get(position).getImageName(), "drawable" , context.getPackageName()))
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return modules.size();
    }

    private void openLessonsActivity(int start, int end, String name) {
        Intent intent = new Intent(context , LessonsActivity.class);
        intent.putExtra("start" , start);
        intent.putExtra("end" , end);
        intent.putExtra("name" , name);
        context.startActivity(intent);
    }

    public static class ModulesViewHolder extends RecyclerView.ViewHolder{
        public TextView moduleName , description;
        public ImageView imageView;
        public ModulesViewHolder(@NonNull View itemView) {
            super(itemView);
            moduleName = (TextView) itemView.findViewById(R.id.tv_name);
            description = (TextView) itemView.findViewById(R.id.tv_description);
            imageView = (ImageView) itemView.findViewById(R.id.iv_illustration);

        }
    }
}
