package com.example.drakalski.beljot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PopPlayerNames extends AppCompatActivity {


    private EditText editTextT1P1;
    private EditText editTextT1P2;
    private EditText editTextT2P1;
    private EditText editTextT2P2;

    private Button btnPlayerUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_player_names);

        btnPlayerUsername = (Button) findViewById(R.id.btnPlayerUsername);
        editTextT1P1 = (EditText) findViewById(R.id.editTextT1P1);
        editTextT1P2 = (EditText) findViewById(R.id.editTextT1P2);
        editTextT2P1 = (EditText) findViewById(R.id.editTextT2P1);
        editTextT2P2 = (EditText) findViewById(R.id.editTextT2P2);


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);


        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*0.9));


        btnPlayerUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                playerName();

            }
        });

    }

    private void playerName(){
        String nameT1P1 = editTextT1P1.getText().toString().trim();
        String nameT1P2 = editTextT1P2.getText().toString().trim();
        String nameT2P1 = editTextT2P1.getText().toString().trim();
        String nameT2P2 = editTextT2P2.getText().toString().trim();

        Intent intent = new Intent();
        intent.putExtra("T1P1", nameT1P1);
        intent.putExtra("T1P2", nameT1P2);
        intent.putExtra("T2P1", nameT2P1);
        intent.putExtra("T2P2", nameT2P2);
        setResult(RESULT_OK, intent);
        finish();
    }
}
