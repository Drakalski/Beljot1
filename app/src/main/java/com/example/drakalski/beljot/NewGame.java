package com.example.drakalski.beljot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewGame extends AppCompatActivity {

    private FirebaseDatabase fdb = FirebaseDatabase.getInstance();

    private int teamOneTotal = 0;
    private int teamTwoTotal = 0;

    public static final int REQUEST_CODE_Names = 100;
    public static final int REQUEST_CODE_Player = 99;
    public static final int REQUEST_CODE_Bonus = 50;
    public static final int REQUEST_CODE_Points = 40;
    public static final int REQUEST_CODE_Trump = 20;
    private TextView teamOneTV;
    private TextView teamTwoTV;
    private TextView teamOnePlayers1;
    private TextView teamOnePlayers2;
    private TextView teamTwoPlayers1;
    private TextView teamTwoPlayers2;

    private TextView textViewT1Total;
    private TextView textViewT2Total;

    private String teamOneName = "";
    private String teamTwoName = "";

    private String teamOnePlayerOne = "";
    private String teamOnePlayerTwo = "";
    private String teamTwoPlayerOne = "";
    private String teamTwoPlayerTwo = "";

    private int teamOnePoints = 0;
    private int teamTwoPoints = 0;

    private int teamOneBonus=0;
    private int teamTwoBonus=0;

    private Button btnBonus;
    private Button btnPoints;
//    private Button btnTrump;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);


        textViewT1Total = (TextView) findViewById(R.id.textViewT1Total);
        textViewT2Total = (TextView) findViewById(R.id.textViewT2Total);
        // TEAM NAME

        teamOneTV = (TextView) findViewById(R.id.textViewT1);
        teamTwoTV = (TextView) findViewById(R.id.textViewT2);

        teamOneTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(), PopNames.class);
                startActivityForResult(intent, REQUEST_CODE_Names);


            }
        });

        teamTwoTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PopNames.class);
                startActivity(intent);

            }
        });


        //TEAM PLAYERS


        teamOnePlayers1 = (TextView) findViewById(R.id.teamOnePlayer1);
        teamOnePlayers2= (TextView) findViewById(R.id.teamOnePlayer2);
        teamTwoPlayers1= (TextView) findViewById(R.id.teamTwoPlayer1);
        teamTwoPlayers2= (TextView) findViewById(R.id.teamTwoPlayer2);



        teamOnePlayers1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PopPlayerNames.class);
                startActivityForResult(intent, REQUEST_CODE_Player);


            }
        });

        teamOnePlayers2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PopPlayerNames.class);
                startActivityForResult(intent, REQUEST_CODE_Player);


            }
        });
        teamTwoPlayers1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PopPlayerNames.class);
                startActivityForResult(intent, REQUEST_CODE_Player);


            }
        });
        teamTwoPlayers2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PopPlayerNames.class);
                startActivityForResult(intent, REQUEST_CODE_Player);


            }
        });

        //TEAM BONUS


        btnBonus = (Button) findViewById(R.id.btnBonus);

        btnBonus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Bonus.class);
                startActivityForResult(intent, REQUEST_CODE_Bonus);

            }
        });


        //TEAM POINTS
        btnPoints = (Button) findViewById(R.id.btnPoints);

        btnPoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GamePoints.class);
                startActivityForResult(intent, REQUEST_CODE_Points);

            }
        });
        //TEAM TRUMP
//        btnTrump = (Button) findViewById(R.id.btnTrump);
//        btnTrump.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), Bonus.class);
//                startActivityForResult(intent, REQUEST_CODE_Trump);
//
//            }
//        });


    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == REQUEST_CODE_Names){
            if(resultCode == RESULT_OK){

                teamOneName = data.getStringExtra("Team One");
                teamTwoName = data.getStringExtra("Team Two");

                teamOneTV.setText(teamOneName.toString());
                teamTwoTV.setText(teamTwoName.toString());

            }
        }

        else if(requestCode == REQUEST_CODE_Player)
        {
            if(resultCode == RESULT_OK)
            {

                teamOnePlayerOne = data.getStringExtra("T1P1");
                teamOnePlayerTwo = data.getStringExtra("T1P2");
                teamTwoPlayerOne = data.getStringExtra("T2P1");
                teamTwoPlayerTwo = data.getStringExtra("T2P2");

                teamOnePlayers1.setText(teamOnePlayerOne);
                teamOnePlayers2.setText(teamOnePlayerTwo);
                teamTwoPlayers1.setText(teamTwoPlayerOne);
                teamTwoPlayers2.setText(teamTwoPlayerTwo);

            }
        }

        else if(requestCode == REQUEST_CODE_Bonus )
        {
            if(resultCode == RESULT_OK){

            teamOneBonus = data.getIntExtra("Team One Bonus", 0);
            teamTwoBonus = data.getIntExtra("Team Two Bonus", 0);


            teamOneTotal = teamOneTotal + teamOneBonus;
            teamTwoTotal = teamTwoTotal + teamOneBonus;

            int num =  Integer.parseInt(textViewT1Total.getText().toString());
            num = num +teamOneBonus;
            textViewT1Total.setText(String.valueOf(num));

            int num2 =  Integer.parseInt(textViewT2Total.getText().toString());
            num2 = num2 +teamTwoBonus;
                if(num >= 1001)
                {

                    textViewT1Total.setText("0");
                    textViewT2Total.setText("0");
                    Intent intent = new Intent(getApplicationContext(), PopWinner.class);
                    intent.putExtra("Winner Name", "Team One Is The Winner!");
                    startActivity(intent);
                }
                else if(num2 >= 1001)

                {
                    textViewT1Total.setText("0");
                    textViewT2Total.setText("0");
                    Intent intent = new Intent(getApplicationContext(), PopWinner.class);
                    intent.putExtra("Winner Name", "Team Two Is The Winner!");
                    startActivity(intent);
                }
                textViewT2Total.setText(String.valueOf(num2));


            }
        }

        if(requestCode == REQUEST_CODE_Points) {
            if (resultCode == RESULT_OK) {

                teamOnePoints = data.getIntExtra("Team One Points", 0);
                teamTwoPoints = data.getIntExtra("Team Two Points", 0);

                teamOneTotal = teamOneTotal + teamOnePoints;
                teamTwoTotal = teamTwoTotal + teamTwoPoints;

                int num =  Integer.parseInt(textViewT1Total.getText().toString());
                num = num +teamOnePoints;
                textViewT1Total.setText(String.valueOf(num));

                int num2 =  Integer.parseInt(textViewT2Total.getText().toString());
                num2 = num2 +teamTwoPoints;
                if(num >= 1001)
                {
                    textViewT1Total.setText("0");
                    textViewT2Total.setText("0");
                    Intent intent = new Intent(getApplicationContext(), PopWinner.class);
                    intent.putExtra("Winner Name", "Team One Is The Winner!");
                    startActivity(intent);
                }
                else if(num2 >= 1001)
                {
                    textViewT1Total.setText("0");
                    textViewT2Total.setText("0");
                    Intent intent = new Intent(getApplicationContext(), PopWinner.class);
                    intent.putExtra("Winner Name", "Team Two Is The Winner!");
                    startActivity(intent);
                }
                textViewT2Total.setText(String.valueOf(num2));



            }
        }

//        if(requestCode == REQUEST_CODE_Trump) {
//            if (resultCode == RESULT_OK) {
//
//            }
//        }


                super.onActivityResult(requestCode, resultCode, data);
    }
}
