package com.example.drakalski.beljot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class PopNames extends Activity {

    private TextView proba1;
    private TextView proba2;
    private EditText editTextTeamOne;
    private EditText editTextTeamTwo;
    private Button btnAccept;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_names);

        btnAccept = (Button) findViewById(R.id.btnAccept);
        editTextTeamOne = (EditText) findViewById(R.id.editTextTeamOne);
        editTextTeamTwo = (EditText) findViewById(R.id.editTextTeamTwo);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);


        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*0.9));

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeName();

            }
        });




    }


    private void changeName()
    {
        String nameTeamOne = editTextTeamOne.getText().toString().trim();
        String nameTeamTwo = editTextTeamTwo.getText().toString().trim();

        Intent intent = new Intent();
        intent.putExtra("Team One", nameTeamOne);
        intent.putExtra("Team Two", nameTeamTwo);

        setResult(RESULT_OK, intent);
        finish();


//        String nameTeamOne = editTextTeamOne.getText().toString().trim();
//        String nameTeamTwo = editTextTeamTwo.getText().toString().trim();
//        Intent intent = new Intent(this, NewGame.class);
//        intent.putExtra("Team One", nameTeamOne);
//        intent.putExtra("Team Two", nameTeamTwo);
//        startActivity(intent);


      //  startActivity(new Intent(getApplicationContext(), PopPlayerNames.class));

    }


}
