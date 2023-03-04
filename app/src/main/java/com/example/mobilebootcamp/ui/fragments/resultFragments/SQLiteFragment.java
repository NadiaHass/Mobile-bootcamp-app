package com.example.mobilebootcamp.ui.fragments.resultFragments;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.mobilebootcamp.R;
import com.example.mobilebootcamp.adapters.SQLiteNotesAdapter;
import com.example.mobilebootcamp.data.sqlite.NoteDatabaseHelper;
import com.example.mobilebootcamp.models.content.Note;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class SQLiteFragment extends Fragment {
    RecyclerView recyclerView;
    NoteDatabaseHelper dbHelper;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_s_q_lite, container, false);
        FloatingActionButton fab = view.findViewById(R.id.floatingActionButton);
        recyclerView = view.findViewById(R.id.rv_notes);

        dbHelper = new NoteDatabaseHelper(requireActivity());

        displayData();

        fab.setOnClickListener(v -> {
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

    private void addNote(String noteContent) {
        Note note = new Note(0 , noteContent);
        dbHelper.addNote(note);
    }

    private void displayData() {
        ArrayList<Note> notes = dbHelper.getAllNotes();
        SQLiteNotesAdapter notesAdapter = new SQLiteNotesAdapter(notes , dbHelper);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity() , RecyclerView.VERTICAL , false));
        recyclerView.setAdapter(notesAdapter);
    }
}