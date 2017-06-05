package com.example.drakalski.beljot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GamePoints extends AppCompatActivity {

    int tim1Poeni = 0;
    int tim2Poeni = 0;

    private EditText editTextT1;
    private EditText editTextT2;
    private Button btnAccept;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popgame_points);

        editTextT1 = (EditText) findViewById(R.id.editTextT1);
        editTextT2 = (EditText) findViewById(R.id.editTextT2);

        btnAccept = (Button) findViewById(R.id.btnAcc);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);


        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*0.9));

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poeni();
            }
        });


    }

    private void poeni(){

        tim1Poeni = Integer.parseInt(editTextT1.getText().toString().trim());
        tim2Poeni = Integer.parseInt(editTextT2.getText().toString().trim());



        if((tim1Poeni+tim2Poeni != 162))
        {
            Toast.makeText(GamePoints.this, "You've entered a wrong amount of points (162 Total)", Toast.LENGTH_SHORT).show();

        }

        else if(tim1Poeni ==0){

            tim2Poeni = 252;
            Intent intent = new Intent();
            intent.putExtra("Team One Points", tim1Poeni);
            intent.putExtra("Team Two Points", tim2Poeni);
            setResult(RESULT_OK, intent);
            finish();

        }

        else if(tim2Poeni == 0)
        {
            tim1Poeni = 252;
            Intent intent = new Intent();
            intent.putExtra("Team One Points", tim1Poeni);
            intent.putExtra("Team Two Points", tim2Poeni);
            setResult(RESULT_OK, intent);
            finish();

        }

        else if((tim1Poeni + tim2Poeni) == 162)
        {
            Intent intent = new Intent();
            intent.putExtra("Team One Points", tim1Poeni);
            intent.putExtra("Team Two Points", tim2Poeni);
            setResult(RESULT_OK, intent);
            finish();
        }


    }
}
