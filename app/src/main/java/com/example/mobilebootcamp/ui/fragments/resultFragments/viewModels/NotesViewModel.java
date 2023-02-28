package com.example.mobilebootcamp.ui.fragments.resultFragments.viewModels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mobilebootcamp.data.room.NotesDatabase;
import com.example.mobilebootcamp.models.content.Note;

import java.util.List;

public class NotesViewModel extends AndroidViewModel {
    private final NotesDatabase notesDatabase;

    public NotesViewModel(Application application) {
        super(application);
        notesDatabase = NotesDatabase.getInstance(application.getApplicationContext());
    }

    public void insertNote(Note note){
        new InsertNoteAsyncTask(notesDatabase).execute(note);
    }

    public LiveData<List<Note>> getAllNotes(){
        return notesDatabase.noteDao().getAllNotes();
    }

    public void deleteNote(Note note){
        new DeleteNoteAsyncTask(notesDatabase).execute(note);
    }


    private static class DeleteNoteAsyncTask extends AsyncTask<Note , Void , Void>{

        private final NotesDatabase notesDatabase;

        public DeleteNoteAsyncTask(NotesDatabase notesDatabase) {
            this.notesDatabase = notesDatabase;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            notesDatabase.noteDao().delete(notes[0]);
            return null;
        }
    }

    private static class InsertNoteAsyncTask extends AsyncTask<Note, Void, Void> {
        private NotesDatabase notesDatabase;

        public InsertNoteAsyncTask(NotesDatabase notesDatabase) {
            this.notesDatabase = notesDatabase;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            notesDatabase.noteDao().insert(notes[0]);
            return null;
        }

    }
}
