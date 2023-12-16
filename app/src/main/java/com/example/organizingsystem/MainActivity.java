package com.example.organizingsystem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//    FloatingActionButton mcreatenotebutton;

    private ListView noteListVIew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();
        setOnClickListener();
        setNoteAdapter();

        setTitle("All Notes");


    }
    private void  initWidgets(){
        noteListVIew = findViewById(R.id.recyclerview);
    }
    private void  setNoteAdapter(){
        NoteAdapter noteAdapter = new NoteAdapter(getApplicationContext(), Note.nonDeletedNotes());
        noteListVIew.setAdapter(noteAdapter);

    }
    private void setOnClickListener()
    {
        noteListVIew.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {
                Note selectedNote = (Note) noteListVIew.getItemAtPosition(position);
                Intent editNoteIntent = new Intent(getApplicationContext(), createnote.class);
                editNoteIntent.putExtra(Note.NOTE_EDIT_EXTRA, selectedNote.getId());
                startActivity(editNoteIntent);
            }
        });
    }
    public void newNote(View view){
        Intent newNoteIntent = new Intent(this, createnote.class);
        startActivity(newNoteIntent);
    }
    @Override
    protected void onResume()
    {
        super.onResume();
        setNoteAdapter();
    }

}