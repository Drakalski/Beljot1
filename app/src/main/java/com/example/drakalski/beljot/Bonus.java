package com.example.drakalski.beljot;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bonus extends AppCompatActivity {


   public boolean teamOneBool = true;
   public boolean teamTwoBool = true;

   public boolean teamOneBelote = true;
   public boolean teamTwoBelote = true;

    int twentyTeamO = 0;
    int fiftyTeamO = 0;
    int hundredTeamO = 0;
    int fourSameTeamO = 0;
    int ninesTeamO = 0;
    int jacksTeamO = 0;
    int beloteTeamO = 0;
    int totalBonusTO = 0;

    int twentyTeamT = 0;
    int fiftyTeamT = 0;
    int hundredTeamT = 0;
    int fourSameTeamT = 0;
    int ninesTeamT = 0;
    int jacksTeamT = 0;
    int beloteTeamT = 0;
    int totalBonusTT = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popbonus);

        Button btnPopUp = (Button) findViewById(R.id.btnPopUp);

        Button btnTwentyTO = (Button) findViewById(R.id.btnTeamOneTwenty);
        Button btnFiftyTO = (Button) findViewById(R.id.btnTeamOneFifty);
        Button btnHundredTO = (Button) findViewById(R.id.btnTeamOneHundred);
        Button btnNinesTO = (Button) findViewById(R.id.btnTeamOneNines);
        Button btnFourSameTO = (Button) findViewById(R.id.btnTeamOneFourSame);
        Button btnJacksTO = (Button) findViewById(R.id.btnTeamOneJacks);
        Button btnBeloteTO = (Button) findViewById(R.id.btnTeamOneBelote);

        Button btnTwentyTT = (Button) findViewById(R.id.btnTeamTwoTwenty);
        Button btnFiftyTT = (Button) findViewById(R.id.btnTeamTwoFifty);
        Button btnHundredTT = (Button) findViewById(R.id.btnTeamTwoHundred);
        Button btnNinesTT = (Button) findViewById(R.id.btnTeamTwoNines);
        Button btnFourSameTT = (Button) findViewById(R.id.btnTeamTwoFourSame);
        Button btnJacksTT = (Button) findViewById(R.id.btnTeamTwoJacks);
        Button btnBeloteTT = (Button) findViewById(R.id.btnTeamTwoBelote);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);


        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*0.9));



        btnPopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendBonus();
            }
        });

        btnTwentyTO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(teamOneBool) {
                    teamTwoBool = false;
                    clickTwentyTO();
                }
                else{
                    return;
                }
            }
        });
        btnFiftyTO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(teamOneBool) {
                    teamTwoBool = false;
                    clickFiftyTO();
                }
                else
                {
                    return;
                }
            }
        });
        btnHundredTO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(teamOneBool) {
                    teamTwoBool = false;
                    clickHundredTO();
                }
                else
                {
                    return;
                }
            }
        });
        btnFourSameTO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(teamOneBool) {
                    teamTwoBool = false;
                    clickFourSameTO();
                }
                else
                {
                    return;
                }
            }
        });
        btnNinesTO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(teamOneBool) {
                    teamTwoBool = false;
                    clickNinesTO();
                }
                else
                {
                    return;
                }
            }
        });
        btnJacksTO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(teamOneBool) {
                    teamTwoBool = false;
                    clickJacksTO();
                }
                else
                {
                    return;
                }
            }
        });
        btnBeloteTO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(teamOneBelote) {
                    teamTwoBelote = false;
                    clickBeloteTO();
                }
                else
                {
                    return;
                }
            }
        });


        btnTwentyTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(teamTwoBool) {
                    teamOneBool = false;
                    clickTwentyTT();
                }
                else
                {
                    return;
                }
            }
        });
        btnFiftyTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(teamTwoBool) {
                    teamOneBool = false;
                    clickFiftyTT();
                }
                else
                {
                    return;
                }
            }
        });
        btnHundredTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(teamTwoBool) {
                    teamOneBool = false;
                    clickHundredTT();
                }
                else
                {
                    return;
                }
            }
        });
        btnFourSameTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (teamTwoBool) {
                    teamOneBool = false;
                    clickFourSameTT();
                }
                else
                {
                    return;
                }
            }

        });
        btnNinesTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(teamTwoBool) {
                    teamOneBool = false;
                    clickNinesTT();
                }
                else
                {
                    return;
                }
            }
        });
        btnJacksTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(teamTwoBool) {
                    teamOneBool = false;
                    clickJacksTT();
                }
                else
                {
                    return;
                }
            }
        });
        btnBeloteTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(teamTwoBelote) {
                    teamOneBelote = false;
                    clickBeloteTT();
                }
                else
                {
                    return;
                }
            }
        });
    }


    private void sendBonus(){

        int teamOneBonus = totalBonusTO;
        int teamTwoBonus = totalBonusTT;
        Intent intent = new Intent();
        intent.putExtra("Team One Bonus", teamOneBonus);
        intent.putExtra("Team Two Bonus", teamTwoBonus);
        setResult(RESULT_OK, intent);
        finish();


    }



    private void clickTwentyTO(){
        if(twentyTeamO < 80)
        {
            twentyTeamO = twentyTeamO+20;
            totalBonusTO = totalBonusTO+20;
            TextView textViewToChange = (TextView) findViewById(R.id.vadenoTeamOne);
            textViewToChange.setText(Integer.toString(totalBonusTO));
        }
        else
        {
            totalBonusTO = totalBonusTO - twentyTeamO;
            if(totalBonusTO == 0 && beloteTeamO == 0)
            {
                teamTwoBool = true;
            }
            twentyTeamO=0;
            TextView textViewToChange = (TextView) findViewById(R.id.vadenoTeamOne);
            textViewToChange.setText(Integer.toString(totalBonusTO));
        }
    }

    private void clickFiftyTO(){
        if(fiftyTeamO < 200)
        {
            fiftyTeamO = fiftyTeamO+50;
            totalBonusTO = totalBonusTO+50;
             TextView textViewToChange = (TextView) findViewById(R.id.vadenoTeamOne);
            textViewToChange.setText(Integer.toString(totalBonusTO));
        }
        else
        {
            totalBonusTO = totalBonusTO - fiftyTeamO;
            if(totalBonusTO == 0 && beloteTeamO == 0)
            {
                teamTwoBool = true;
            }
            fiftyTeamO=0;
             TextView textViewToChange = (TextView) findViewById(R.id.vadenoTeamOne);
            textViewToChange.setText(Integer.toString(totalBonusTO));

        }
    }


    private void clickHundredTO(){
        if(hundredTeamO < 200)
        {
            hundredTeamO = hundredTeamO+50;
            totalBonusTO = totalBonusTO+50;
             TextView textViewToChange = (TextView) findViewById(R.id.vadenoTeamOne);
            textViewToChange.setText(Integer.toString(totalBonusTO));
        }
        else
        {
            totalBonusTO = totalBonusTO - hundredTeamO;
            if(totalBonusTO == 0 && beloteTeamO == 0)
            {
                teamTwoBool = true;
            }
            hundredTeamO=0;
             TextView textViewToChange = (TextView) findViewById(R.id.vadenoTeamOne);
            textViewToChange.setText(Integer.toString(totalBonusTO));

        }
    }
    private void clickFourSameTO(){
        if(fourSameTeamO < 400)
        {
            fourSameTeamO = fourSameTeamO+100;
            totalBonusTO = totalBonusTO+100;
             TextView textViewToChange = (TextView) findViewById(R.id.vadenoTeamOne);
            textViewToChange.setText(Integer.toString(totalBonusTO));
        }
        else
        {
            totalBonusTO = totalBonusTO - fourSameTeamO;
            if(totalBonusTO == 0 && beloteTeamO == 0)
            {
                teamTwoBool = true;
            }
            fourSameTeamO=0;
             TextView textViewToChange = (TextView) findViewById(R.id.vadenoTeamOne);
            textViewToChange.setText(Integer.toString(totalBonusTO));

        }
    }
    private void clickJacksTO(){
        if(jacksTeamO < 199)
        {
            jacksTeamO = jacksTeamO+200;
            totalBonusTO = totalBonusTO+200;
             TextView textViewToChange = (TextView) findViewById(R.id.vadenoTeamOne);
            textViewToChange.setText(Integer.toString(totalBonusTO));
        }
        else
        {
            totalBonusTO = totalBonusTO - jacksTeamO;
            if(totalBonusTO == 0 && beloteTeamO == 0)
            {
                teamTwoBool = true;
            }
            jacksTeamO=0;
             TextView textViewToChange = (TextView) findViewById(R.id.vadenoTeamOne);
            textViewToChange.setText(Integer.toString(totalBonusTO));

        }
    }
    private void clickNinesTO(){
        if(ninesTeamO < 150)
        {
            ninesTeamO = ninesTeamO+150;
            totalBonusTO = totalBonusTO+150;
             TextView textViewToChange = (TextView) findViewById(R.id.vadenoTeamOne);
            textViewToChange.setText(Integer.toString(totalBonusTO));
        }
        else
        {
            totalBonusTO = totalBonusTO - ninesTeamO;
            if(totalBonusTO == 0 && beloteTeamO == 0)
            {
                teamTwoBool = true;
            }
            ninesTeamO=0;
             TextView textViewToChange = (TextView) findViewById(R.id.vadenoTeamOne);
            textViewToChange.setText(Integer.toString(totalBonusTO));

        }
    }
    private void clickBeloteTO(){
        if(beloteTeamO < 20)
        {
            beloteTeamO = beloteTeamO +20;
            totalBonusTO = totalBonusTO+20;
             TextView textViewToChange = (TextView) findViewById(R.id.vadenoTeamOne);
            textViewToChange.setText(Integer.toString(totalBonusTO));
        }
        else
        {
            totalBonusTO = totalBonusTO - beloteTeamO;
            beloteTeamO=0;
            teamTwoBelote=true;
             TextView textViewToChange = (TextView) findViewById(R.id.vadenoTeamOne);
            textViewToChange.setText(Integer.toString(totalBonusTO));
        }
    }
    private void clickTwentyTT(){
        if(twentyTeamT < 80)
        {
            twentyTeamT = twentyTeamT+20;
            totalBonusTT = totalBonusTT+20;
             TextView textViewToChange = (TextView) findViewById(R.id.vadenoTeamTwo);
            textViewToChange.setText(Integer.toString(totalBonusTT));
        }
        else
        {
            totalBonusTT = totalBonusTT - twentyTeamT;
            twentyTeamT=0;
            if(totalBonusTT == 0 && beloteTeamT == 0)
            {
                teamOneBool = true;
            }
             TextView textViewToChange = (TextView) findViewById(R.id.vadenoTeamTwo);
            textViewToChange.setText(Integer.toString(totalBonusTT));

        }
    }
    private void clickFiftyTT(){
        if(fiftyTeamT < 200)
        {
            fiftyTeamT = fiftyTeamT+50;
            totalBonusTT = totalBonusTT+50;
             TextView textViewToChange = (TextView) findViewById(R.id.vadenoTeamTwo);
            textViewToChange.setText(Integer.toString(totalBonusTT));
        }
        else
        {
            totalBonusTT = totalBonusTT - fiftyTeamT;
            if(totalBonusTT == 0 && beloteTeamT == 0)
            {
                teamOneBool = true;
            }
            fiftyTeamT=0;
             TextView textViewToChange = (TextView) findViewById(R.id.vadenoTeamTwo);
            textViewToChange.setText(Integer.toString(totalBonusTT));

        }
    }
    private void clickHundredTT(){
        if(hundredTeamT < 200)
        {
            hundredTeamT = hundredTeamT+50;
            totalBonusTT = totalBonusTT+50;
             TextView textViewToChange = (TextView) findViewById(R.id.vadenoTeamTwo);
            textViewToChange.setText(Integer.toString(totalBonusTT));
        }
        else
        {
            totalBonusTT = totalBonusTT - hundredTeamT;
            if(totalBonusTT == 0 && beloteTeamT == 0)
            {
                teamOneBool = true;
            }
            hundredTeamT=0;
             TextView textViewToChange = (TextView) findViewById(R.id.vadenoTeamTwo);
            textViewToChange.setText(Integer.toString(totalBonusTT));

        }
    }
    private void clickFourSameTT(){
        if(fourSameTeamT < 400)
        {
            fourSameTeamT = fourSameTeamT+100;
            totalBonusTT = totalBonusTT+100;
             TextView textViewToChange = (TextView) findViewById(R.id.vadenoTeamTwo);
            textViewToChange.setText(Integer.toString(totalBonusTT));
        }
        else
        {
            totalBonusTT = totalBonusTT - fourSameTeamT;
            if(totalBonusTT == 0 && beloteTeamT == 0)
            {
                teamOneBool = true;
            }
            fourSameTeamT=0;
             TextView textViewToChange = (TextView) findViewById(R.id.vadenoTeamTwo);
            textViewToChange.setText(Integer.toString(totalBonusTT));

        }
    }
    private void clickJacksTT(){
        if(jacksTeamT < 200)
        {
            jacksTeamT = jacksTeamT+200;
            totalBonusTT = totalBonusTT+200;
            TextView textViewToChange = (TextView) findViewById(R.id.vadenoTeamTwo);
            textViewToChange.setText(Integer.toString(totalBonusTT));
        }
        else
        {
            totalBonusTT = totalBonusTT - jacksTeamT;
            if(totalBonusTT == 0 && beloteTeamT == 0)
            {
                teamOneBool = true;
            }
            jacksTeamT=0;
             TextView textViewToChange = (TextView) findViewById(R.id.vadenoTeamTwo);
            textViewToChange.setText(Integer.toString(totalBonusTT));

        }
    }
    private void clickNinesTT(){
        if(ninesTeamT < 150)
        {
            ninesTeamT = ninesTeamT+150;
            totalBonusTT = totalBonusTT+150;
             TextView textViewToChange = (TextView) findViewById(R.id.vadenoTeamTwo);
            textViewToChange.setText(Integer.toString(totalBonusTT));
        }
        else
        {
            totalBonusTT = totalBonusTT - ninesTeamT;
            if(totalBonusTT == 0 && beloteTeamT == 0)
            {
                teamOneBool = true;
            }
            ninesTeamT=0;
             TextView textViewToChange = (TextView) findViewById(R.id.vadenoTeamTwo);
            textViewToChange.setText(Integer.toString(totalBonusTT));

        }
    }
    private void clickBeloteTT(){
        if(beloteTeamT < 20)
        {
            beloteTeamT = beloteTeamT +20;
            totalBonusTT = totalBonusTT+20;
             TextView textViewToChange = (TextView) findViewById(R.id.vadenoTeamTwo);
            textViewToChange.setText(Integer.toString(totalBonusTT));
        }
        else
        {
            totalBonusTT = totalBonusTT - beloteTeamT;
            beloteTeamT=0;
            teamOneBelote=true;
             TextView textViewToChange = (TextView) findViewById(R.id.vadenoTeamTwo);
            textViewToChange.setText(Integer.toString(totalBonusTT));
        }
    }
}
