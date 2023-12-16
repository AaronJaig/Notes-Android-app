package com.example.organizingsystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.widget.TextView;

//import androidx.annotation.NonNull;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class NoteAdapter  extends ArrayAdapter<Note>
{
    public NoteAdapter(Context context, List<Note> notes) {
        super(context, 0, notes);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        Note note = getItem(position);
        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.notes_layout, parent, false);
        TextView title = convertView.findViewById(R.id.notetitle);
        TextView desc = convertView.findViewById(R.id.notecontent);

        title.setText(note.getTitle());
        desc.setText(note.getContent());

        return convertView;
    }
}
