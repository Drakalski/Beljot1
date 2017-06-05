package com.example.drakalski.beljot;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.TextUtils;
import android.util.Log;
import android.view.*;
import android.widget.*;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;


public class LoginActivity extends AppCompatActivity  {

    public static int won = 0;
    public static int lost =0;
    private Boolean login =false;
    private FirebaseAuth firebaseAuth;
    private Button btnSignIn;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button btnSignUp;
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseMessaging.getInstance().subscribeToTopic("Winner");
        if(!login)
        {


        firebaseAuth.signInWithEmailAndPassword("adrakalski@gmail.com", "220404").addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    login = true;
                }
            }
        });

        }
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);

        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);


        btnSignIn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                clickSignIn();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickSignUp();
            }


        });

    }


    private void clickSignIn(){
        final String username = editTextUsername.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();

        if(TextUtils.isEmpty(username)){
            Toast.makeText(this, "Please enter your username", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show();
            return;

        }

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.child("User").getChildren())
                {
                    if(ds.getKey().equals(username))
                    {
                        for(DataSnapshot dss : ds.getChildren())
                        {
//                           won =  dss.child("Won Games").getValue(Integer.class);
//                           lost =  dss.child("Lost Games").getValue(Integer.class);
                            if(dss.getKey().equals("Password"))
                            {
                                if (dss.getValue().equals(password))
                                {
                                    startActivity(new Intent(getApplicationContext(), Menu.class));
                                }
                                else{
                                    Toast.makeText(LoginActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                                }



                            }

                        }
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


    private void clickSignUp(){
        finish();
        startActivity(new Intent (this, Signup.class));
            }


    }



