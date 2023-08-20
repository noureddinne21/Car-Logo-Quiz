package com.example.carlogoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    private Button b1,b2;
    private ProgressBar progressBar;
    private int i = 0;
    private TextView tca,tra;
    String ca="0",ra="0";
    int progress=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        b1=findViewById(R.id.button_p);
        b2=findViewById(R.id.button_q);
        tca=findViewById(R.id.textView11);
        tra=findViewById(R.id.textView12);
        progressBar=findViewById(R.id.progressBar);

        Bundle b = getIntent().getExtras();
        if (b!=null){

             ca = b.getString("ca");
             ra = b.getString("ra");

        }

        tca.setText(ca);
        tra.setText(ra);
        progress=Integer.parseInt(ca)*10;


        CountDownTimer y = new CountDownTimer(5000,50) {
            @Override
            public void onTick(long millisUntilFinished) {

                if (i==progress){
                }else {
                    i += 1;
                    progressBar.setProgress(i);
                }
            }
            @Override
            public void onFinish() {
            }
        }.start();





        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ResultActivity.this,GameActivity.class);
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });


    }
}