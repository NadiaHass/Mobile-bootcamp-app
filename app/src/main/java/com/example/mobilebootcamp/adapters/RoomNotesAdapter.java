package com.example.mobilebootcamp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilebootcamp.R;
import com.example.mobilebootcamp.models.content.Note;
import com.example.mobilebootcamp.ui.fragments.resultFragments.viewModels.NotesViewModel;

import java.util.List;

public class RoomNotesAdapter  extends RecyclerView.Adapter<RoomNotesAdapter.NotesViewHolder> {
    private List<Note> notes;
    private NotesViewModel notesViewModel;

    public RoomNotesAdapter(List<Note> notes, NotesViewModel notesViewModel) {
        this.notes = notes;
        this.notesViewModel = notesViewModel;
    }


    @NonNull
    @Override
    public RoomNotesAdapter.NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RoomNotesAdapter.NotesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.note_rv_item , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        holder.noteContent.setText(notes.get(position).getContent());

        holder.deleteImageView.setOnClickListener(v -> {
            notesViewModel.deleteNote(notes.get(position));
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