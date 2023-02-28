package com.example.mobilebootcamp.ui.fragments.resultFragments;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilebootcamp.R;
import com.example.mobilebootcamp.adapters.RoomNotesAdapter;
import com.example.mobilebootcamp.models.content.Note;
import com.example.mobilebootcamp.ui.fragments.resultFragments.viewModels.NotesViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class RoomDbFragment extends Fragment {
    RecyclerView recyclerView;
    NotesViewModel notesViewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_room_db, container, false);

        FloatingActionButton fab = view.findViewById(R.id.floatingActionButton);
        recyclerView = view.findViewById(R.id.rv_notes);

        notesViewModel = new ViewModelProvider(requireActivity()).get(NotesViewModel.class);

        displayData();

        fab.setOnClickListener(v->{
            showDialog();
        });

        return view;
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        View dialogView = getLayoutInflater().inflate(R.layout.add_note_dialog, null);
        builder.setView(dialogView);
        EditText noteEditText = dialogView.findViewById(R.id.et_note);


        builder.setPositiveButton("Add", (dialog, which) -> {

            String noteContent = noteEditText.getText().toString().trim();
            if (!noteContent.isEmpty()) {
                addNote(noteContent);

                displayData();

            }
        });

        builder.setNegativeButton("Cancel" , (dialog, which) -> {
            dialog.dismiss();
        });
        builder.show();
    }

    private void displayData() {
        notesViewModel.getAllNotes().observe(getViewLifecycleOwner(), notes1 -> {
            List<Note> notes  = notes1;
            RoomNotesAdapter notesAdapter = new RoomNotesAdapter(notes , notesViewModel);
            recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity() , RecyclerView.VERTICAL , false));
            recyclerView.setAdapter(notesAdapter);
        });
    }

    private void addNote(String noteContent) {
        notesViewModel.insertNote(new Note(0 , noteContent));
    }
}