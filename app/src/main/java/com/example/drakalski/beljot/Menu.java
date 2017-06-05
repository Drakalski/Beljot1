package com.example.drakalski.beljot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Menu extends AppCompatActivity {


    private FirebaseAuth firebaseAuth;

   // private TextView textviewUserEmail;
    private Button btnLogout;
    private Button btnNewGame;
    private Button btnFriends;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null)
        {
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

        // textviewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
        btnLogout = (Button) findViewById(R.id.btnLogout);
        btnNewGame = (Button) findViewById(R.id.btnNewGame);
        btnFriends = (Button) findViewById(R.id.btnWins);


        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }


        });

        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), NewGame.class));
            }


        });
        btnFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), Win.class));
            }


        });


    }
}
