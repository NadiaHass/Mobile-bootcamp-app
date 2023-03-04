package com.example.mobilebootcamp.ui.fragments.resultFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.mobilebootcamp.R;
import com.example.mobilebootcamp.adapters.NotesAdapter;
import com.example.mobilebootcamp.adapters.SQLiteNotesAdapter;
import com.example.mobilebootcamp.models.content.Note;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class FirestoreFragment extends Fragment {
    FirebaseFirestore firebaseFirestore;
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_firestore, container, false);

        firebaseFirestore = FirebaseFirestore.getInstance();

        recyclerView = view.findViewById(R.id.rv_notes);
        ProgressBar progressBar = view.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        // write data
//        addNoteToDb(new Note(0 , "My first note"));
//        addNoteToDb(new Note(1 , "My second note"));
//        addNoteToDb(new Note(2 , "My third note"));
//        addNoteToDb(new Note(0 , "My first note"));
//        addNoteToDb(new Note(1 , "My second note"));
//        addNoteToDb(new Note(2 , "My third note"));

        //get and display data
        firebaseFirestore.collection("notes")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        ArrayList<Note> notes = new ArrayList<>();

                        for(QueryDocumentSnapshot document : task.getResult()){
                            Note note = document.toObject(Note.class);
                            notes.add(note);
                            setupRecyclerView(notes);
                            progressBar.setVisibility(View.GONE);

                        }
                    }
                });



        return view;
    }

    private void addNoteToDb(Note note) {
        firebaseFirestore.collection("notes").document().set(note).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                // u can do something here
            }
        });
    }

    private void setupRecyclerView(ArrayList<Note> notes) {
        NotesAdapter notesAdapter = new NotesAdapter(notes);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity() , RecyclerView.VERTICAL , false));
        recyclerView.setAdapter(notesAdapter);

    }
}