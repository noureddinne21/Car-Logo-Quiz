package com.example.carlogoquiz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Model_Database extends SQLiteOpenHelper {
    public Model_Database(@Nullable Context context) {
        super(context, "quizgame.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE  IF NOT EXISTS \"flagquizgametable\" (\n" +
                "\t\"flag_id\"\tINTEGER,\n" +
                "\t\"flag_name\"\tTEXT,\n" +
                "\t\"flag_image\"\tTEXT\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("Drop TABLE  IF EXISTS flagquizgametable");
        onCreate(db);
    }
}
