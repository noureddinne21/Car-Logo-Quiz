package com.example.carlogoquiz;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ModelDAO {

    public ArrayList<Model>GetRandomQuistoin(Model_Database md){

        ArrayList<Model>  ModelArrayList = new ArrayList<>();
        SQLiteDatabase db = md.getWritableDatabase();
        Cursor cursor =db.rawQuery("SELECT * FROM flagquizgametable ORDER BY RANDOM () LIMIT 26",null);

        int IdIndex= cursor.getColumnIndex("flag_id");
        int NameIndex= cursor.getColumnIndex("flag_name");
        int ImgIndex= cursor.getColumnIndex("flag_image");

        while (cursor.moveToNext()){

            Model model = new Model(cursor.getInt(IdIndex),cursor.getString(NameIndex),cursor.getString(ImgIndex));
            ModelArrayList.add(model);

        }

        return ModelArrayList;
    }

    public ArrayList<Model>GetRandomOption(Model_Database md, int flag_id){

        ArrayList<Model>  ModelArrayList = new ArrayList<>();
        SQLiteDatabase db = md.getWritableDatabase();
        Cursor cursor =db.rawQuery("SELECT * FROM flagquizgametable WHERE flag_id !="+flag_id+" ORDER BY RANDOM () LIMIT 2",null);

        int IdIndex= cursor.getColumnIndex("flag_id");
        int NameIndex= cursor.getColumnIndex("flag_name");
        int ImgIndex= cursor.getColumnIndex("flag_image");

        while (cursor.moveToNext()){

            Model model = new Model(cursor.getInt(IdIndex),cursor.getString(NameIndex),cursor.getString(ImgIndex));
            ModelArrayList.add(model);

        }

        return ModelArrayList;
    }

}
