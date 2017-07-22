package com.example.starhood.habittrackingapp;

import android.provider.BaseColumns;

/**
 * Created by Starhood on 7/4/17.
 */

public final class Contract {

    public static final class HabitEntry implements BaseColumns {

        public static final String TABLE_NAME = "habit";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_Habit = "name";
        public static final String COLUMN_Date = "date";
        public static final String COLUMN_PRACTICE = "practice";

        public static final int LOW_PRACTICE = 0;
        public static final int MIDDEN_PRACTICE = 1;
        public static final int ALOT_PRACTICE = 2;

    }
}
