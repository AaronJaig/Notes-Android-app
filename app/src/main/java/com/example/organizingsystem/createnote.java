package com.example.organizingsystem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class createnote extends AppCompatActivity {
    private  EditText titleEditText, contentedittext;
    private Note selectedNote;
    private FloatingActionButton deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createnote);
        initWidgets();
        checkForEditNote();
    }
    private void initWidgets(){
        titleEditText = findViewById(R.id.createtitleofnote);
        contentedittext = findViewById(R.id.createcontentofnote);
        deleteButton = findViewById(R.id.delete);
    }
    public void saveNote(View view){
        String title = String.valueOf(titleEditText.getText());
        String content = String.valueOf(contentedittext.getText());
        if (selectedNote == null){
            int id = Note.noteArrayList.size();
            Note newNote = new Note(id, title, content);
            Note.noteArrayList.add(newNote);
        }else{
            selectedNote.setTitle(title);
            selectedNote.setContent(content);
        }
        finish();

    }
    private void checkForEditNote()
    {
        Intent previousIntent = getIntent();

        int passedNoteID = previousIntent.getIntExtra(Note.NOTE_EDIT_EXTRA, -1);
        selectedNote = Note.getNoteForID(passedNoteID);

        if (selectedNote != null)
        {
            titleEditText.setText(selectedNote.getTitle());
            contentedittext.setText(selectedNote.getContent());
        }
        else
        {
            deleteButton.setVisibility(View.INVISIBLE);
        }
    }
    public void deleteNote(View view) {
        // Find the note in the list based on its ID
        selectedNote.setDeleted(new Date());
        finish();
    }


    }