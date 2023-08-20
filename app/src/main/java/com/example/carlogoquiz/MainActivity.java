package com.example.carlogoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);


        CopyDatabase();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,GameActivity.class);
                startActivity(i);
            }
        });
    }

    public void CopyDatabase(){


        try {

            DatabaseCopyHelper databaseCopyHelper = new DatabaseCopyHelper(MainActivity.this);
            databaseCopyHelper.createDataBase();
            databaseCopyHelper.openDataBase();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}