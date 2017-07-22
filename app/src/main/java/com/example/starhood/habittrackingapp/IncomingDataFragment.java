package com.example.starhood.habittrackingapp;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.starhood.habittrackingapp.Contract.HabitEntry;

/**
 * A simple {@link Fragment} subclass.
 */
public class IncomingDataFragment extends Fragment {

    DataBaseHelper dh;
    TextView habit;
    TextView date;
    Spinner spinner;

    public IncomingDataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_insert_data, container, false);

        dh = new DataBaseHelper(getActivity());

        spinner = (Spinner) rootView.findViewById(R.id.spinner);
        habit = (TextView) rootView.findViewById(R.id.habitInput);
        date = (TextView) rootView.findViewById(R.id.dateInput);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.spinner_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button btn = (Button) rootView.findViewById(R.id.submitbtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });

        return rootView;
    }

    private void insertData() {
        SQLiteDatabase db = dh.getWritableDatabase();

        ContentValues values = new ContentValues();
        int option = spinner.getSelectedItemPosition();
        values.put(HabitEntry.COLUMN_Habit, habit.getText().toString().trim());
        values.put(HabitEntry.COLUMN_Date, date.getText().toString().trim());
        values.put(HabitEntry.COLUMN_PRACTICE, option);


        db.insert(HabitEntry.TABLE_NAME, null, values);


    }

}
