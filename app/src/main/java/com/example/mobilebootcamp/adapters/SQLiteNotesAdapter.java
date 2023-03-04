package com.example.mobilebootcamp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilebootcamp.R;
import com.example.mobilebootcamp.data.sqlite.NoteDatabaseHelper;
import com.example.mobilebootcamp.models.content.Note;

import java.util.ArrayList;

public class SQLiteNotesAdapter extends RecyclerView.Adapter<SQLiteNotesAdapter.NotesViewHolder> {
    private ArrayList<Note> notes;
    private NoteDatabaseHelper dbHelper;

    public SQLiteNotesAdapter(ArrayList<Note> notes, NoteDatabaseHelper dbHelper) {
        this.notes = notes;
        this.dbHelper = dbHelper;
    }


    @NonNull
    @Override
    public SQLiteNotesAdapter.NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SQLiteNotesAdapter.NotesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.note_rv_item , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull SQLiteNotesAdapter.NotesViewHolder holder, int position) {
        holder.noteContent.setText(notes.get(position).getContent());

        holder.deleteImageView.setOnClickListener(v -> {
            dbHelper.deleteNoteById(notes.get(position).getId());
        });

        holder.itemView.setOnClickListener(v -> {
            // put here the code if item is clicked
        });
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public static class NotesViewHolder extends RecyclerView.ViewHolder{
        public TextView noteContent;
        public ImageView deleteImageView;
        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);

            noteContent = itemView.findViewById(R.id.tv_note_content);
            deleteImageView = itemView.findViewById(R.id.iv_delete);
        }
    }
}

