package com.example.starhood.habittrackingapp;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.starhood.habittrackingapp.Contract.HabitEntry;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewData extends Fragment {

    View rootView;

    public ViewData() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.viewdata, container, false);

        displayDatabaseInfo();

        Button btn = (Button) rootView.findViewById(R.id.refresh);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayDatabaseInfo();
            }
        });

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        displayDatabaseInfo();
    }

    @Override
    public void onResume() {
        super.onResume();
        displayDatabaseInfo();
    }

    public void displayDatabaseInfo() {

        DataBaseHelper dataBaseHelper = new DataBaseHelper(getActivity());
        SQLiteDatabase db = dataBaseHelper.getReadableDatabase();


        Cursor cursor = db.rawQuery("SELECT * FROM " + HabitEntry.TABLE_NAME, null);

        String data = "";
        String buffer;

        while (cursor.moveToNext()) {
            int ColumnIndexzero = cursor.getColumnIndex(HabitEntry._ID);
            int ColumnIndexone = cursor.getColumnIndex(HabitEntry.COLUMN_Habit);
            int ColumnIndexthree = cursor.getColumnIndex(HabitEntry.COLUMN_Date);
            int ColumnIndextwo = cursor.getColumnIndex(HabitEntry.COLUMN_PRACTICE);

            int practice = cursor.getInt(ColumnIndextwo);
            if (practice == 0)
                buffer = "often";
            else if (practice == 1)
                buffer = "usually";
            else if (practice == 2)
                buffer = "A lot";
            else buffer = "Don't Know";

            data += cursor.getInt(ColumnIndexzero) + "  " + cursor.getString(ColumnIndexone) + "  " + cursor.getString(ColumnIndexthree) + "  " + buffer + "  \n";
            buffer = "";
        }
        try {
            TextView view = (TextView) rootView.findViewById(R.id.mtextbox);
            view.setText(data);

        } finally {
            cursor.close();
        }
    }

}
