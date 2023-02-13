package com.example.mobilebootcamp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilebootcamp.R;

import java.util.ArrayList;

public class LanguagesAdapter extends RecyclerView.Adapter<LanguagesAdapter.LanguageViewHolder> {
    private ArrayList<String> mLanguageList;

    public LanguagesAdapter(ArrayList<String> mLanguageList) {
        this.mLanguageList = mLanguageList;
    }


    @NonNull
    @Override
    public LanguagesAdapter.LanguageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LanguagesAdapter.LanguageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.languages_rv_item , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull LanguagesAdapter.LanguageViewHolder holder, int position) {
        holder.languageName.setText(mLanguageList.get(position));
        holder.itemView.setOnClickListener(v -> {
            // put here the code if item is clicked
        });
    }

    @Override
    public int getItemCount() {
        return mLanguageList.size();
    }

    public static class LanguageViewHolder extends RecyclerView.ViewHolder{
        public TextView languageName;
        public LanguageViewHolder(@NonNull View itemView) {
            super(itemView);

            languageName = itemView.findViewById(R.id.tv_language);
        }
    }
}
