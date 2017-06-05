package com.example.drakalski.beljot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

public class PopTrump extends AppCompatActivity {

    private Button btnTeamOneTrump;
    private Button btnTeamTwoTrump;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_trump);

        btnTeamOneTrump = (Button) findViewById(R.id.btnTeamOneTrump);
        btnTeamTwoTrump = (Button) findViewById(R.id.btnTeamTwoTrump);


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);


        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*0.9));

        btnTeamOneTrump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                t1Trump();

            }
        });

        btnTeamTwoTrump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                t2Trump();

            }
        });

    }

    private void t1Trump(){

        Boolean bool1 = true;
        Intent intent = new Intent();
        intent.putExtra("T1Trump", bool1);
        startActivity(intent);



    }

    private void t2Trump(){

        Boolean bool2 = false;
        Intent intent = new Intent();
        intent.putExtra("T2Trump", bool2);
        startActivity(intent);



    }
}
