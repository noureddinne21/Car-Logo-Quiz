package com.example.carlogoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;

public class GameActivity extends AppCompatActivity {
    private Model_Database model_database;
    private ArrayList<Model> quistionlist;
    private Model corectAnswer;
    private ArrayList<Model> wronganswer;
    private ArrayList<Model> option = new ArrayList<>();
    private HashSet <Model> mixoption = new HashSet<>();
    private Button button;
    private TextView tq,tc,tr,b1,b2,b3;
    private ImageView img;

    private int corect = 0;
    private int wrong = 0;
    private int quition = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        button=findViewById(R.id.button_next);
        b1=findViewById(R.id.button2);
        b2=findViewById(R.id.button3);
        b3=findViewById(R.id.button4);
        tq=findViewById(R.id.textView7);
        tr=findViewById(R.id.textView6);
        tc=findViewById(R.id.textView8);
        img=findViewById(R.id.imageView);

        model_database = new Model_Database(GameActivity.this);
        quistionlist= new ModelDAO().GetRandomQuistoin(model_database);

        button.setVisibility(View.GONE);


        loadquition();
        quition++;



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                actionbutton(1);

            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                actionbutton(2);

            }
        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                actionbutton(3);

            }
        });




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(GameActivity.this,ResultActivity.class);
                i.putExtra("ca",tc.getText().toString());
                i.putExtra("ra",tr.getText().toString());
                startActivity(i);

            }
        });
    }


    public void loadquition(){

        b1.setClickable(true);
        b2.setClickable(true);
        b3.setClickable(true);

        b1.setBackgroundResource(R.color.orange);
        b2.setBackgroundResource(R.color.orange);
        b3.setBackgroundResource(R.color.orange);


        tq.setText(String.valueOf(quition+1));
        corectAnswer=quistionlist.get(quition);
        img.setImageResource(getResources().getIdentifier(corectAnswer.getModel_img(),"drawable",getPackageName()));

        wronganswer= new ModelDAO().GetRandomOption(model_database,corectAnswer.getModel_id());

        mixoption.clear();
        mixoption.add(corectAnswer);
        mixoption.add(wronganswer.get(0));
        mixoption.add(wronganswer.get(1));

        option.clear();


        for (Model m : mixoption){

            option.add(m);

        }

        b1.setText(option.get(0).getModel_name());
        b2.setText(option.get(1).getModel_name());
        b3.setText(option.get(2).getModel_name());

    }




    public void actionbutton(int pos){

        b1.setClickable(false);
        b2.setClickable(false);
        b3.setClickable(false);


        switch (pos){

            case 1:

                if (b1.getText().equals(corectAnswer.getModel_name())){
                    b1.setBackgroundResource(R.color.GREEN);
                    corect++;
                }else {
                    b1.setBackgroundResource(R.color.RED);
                    wrong++;
                    if (b2.getText().equals(corectAnswer.getModel_name())){
                        b2.setBackgroundResource(R.color.GREEN);
                    }else if (b3.getText().equals(corectAnswer.getModel_name())){
                        b3.setBackgroundResource(R.color.GREEN);
                    }
                }

                break;

            case 2:

                if (b2.getText().equals(corectAnswer.getModel_name())){
                    b2.setBackgroundResource(R.color.GREEN);
                    corect++;
                }else {
                    b2.setBackgroundResource(R.color.RED);
                    wrong++;
                    if (b3.getText().equals(corectAnswer.getModel_name())){
                        b3.setBackgroundResource(R.color.GREEN);
                    }else if (b1.getText().equals(corectAnswer.getModel_name())){
                        b1.setBackgroundResource(R.color.GREEN);
                    }
                }

                break;

            case 3:

                if (b3.getText().equals(corectAnswer.getModel_name())){
                    b3.setBackgroundResource(R.color.GREEN);
                    corect++;
                }else {
                    b3.setBackgroundResource(R.color.RED);
                    wrong++;
                    if (b2.getText().equals(corectAnswer.getModel_name())){
                        b2.setBackgroundResource(R.color.GREEN);
                    }else if (b1.getText().equals(corectAnswer.getModel_name())){
                        b1.setBackgroundResource(R.color.GREEN);
                    }
                }

                break;


            }
            CountDownTimer t =new CountDownTimer(2000,1000) {
                @Override
                public void onTick(long millisUntilFinished) {

                }
                @Override
                public void onFinish() {
                    if (quition==10){
                        button.setVisibility(View.VISIBLE);
                    }else {
                        loadquition();
                        quition++;
                    }
                }
            }.start();

            tc.setText(String.valueOf(corect));
            tr.setText(String.valueOf(wrong));

        }


















}