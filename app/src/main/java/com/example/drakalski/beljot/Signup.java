package com.example.drakalski.beljot;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    public static String user;
    int id = 0;
    private DatabaseReference databaseReference;
    private FirebaseDatabase fdb = FirebaseDatabase.getInstance();
    private Button btnSUp;
    private EditText editTextFirstname;
    private EditText editTextLastname;
    private EditText editTextUser;
    private EditText editTextPass;
    private EditText editTextConfPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);


        btnSUp = (Button) findViewById(R.id.btnSignUp);
        firebaseAuth = FirebaseAuth.getInstance();


        editTextFirstname = (EditText) findViewById(R.id.editTextFirstname);
        editTextLastname = (EditText) findViewById(R.id.editTextLastname);
        editTextUser = (EditText) findViewById(R.id.editTextUser);
        editTextPass = (EditText) findViewById(R.id.editTextPass);
        editTextConfPass = (EditText) findViewById(R.id.editTextConfPass);



        btnSUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp();

            }
        });
    }

    private void signUp() {
       user = editTextUser.getText().toString().trim();
        String password = editTextPass.getText().toString().trim();
        String confPass = editTextConfPass.getText().toString().trim();
        String firstName = editTextFirstname.getText().toString().trim();
        String lastName = editTextLastname.getText().toString().trim();


        if (TextUtils.isEmpty(firstName)) {
            Toast.makeText(this, "Please enter your First Name", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(lastName)) {
            Toast.makeText(this, "Please enter your Last Name", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(user)) {
            Toast.makeText(this, "Please enter your Username", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show();
            return;

        }

        if (TextUtils.isEmpty(confPass)) {
            Toast.makeText(this, "Please enter your confirmation password", Toast.LENGTH_SHORT).show();
            return;
        }

                  if (!password.equals(confPass)) {
                editTextFirstname = (EditText) findViewById(R.id.editTextFirstname);
                editTextLastname = (EditText) findViewById(R.id.editTextLastname);
                editTextUser = (EditText) findViewById(R.id.editTextUser);
                editTextPass = (EditText) findViewById(R.id.editTextPass);
                editTextConfPass = (EditText) findViewById(R.id.editTextConfPass);

                editTextFirstname.setText("");
                editTextLastname.setText("");
                editTextUser.setText("");
                editTextPass.setText("");
                editTextConfPass.setText("");


                Toast.makeText(this, "You have entered an incorrect password for confirmation", Toast.LENGTH_SHORT).show();
                return;

        } else {


            DatabaseReference dbr = FirebaseDatabase.getInstance().getReference();
            dbr = fdb.getReference("User").child(user);
            dbr.child("Name").setValue(firstName);
            dbr.child("Last Name").setValue(lastName);
            dbr.child("Password").setValue(password);
            dbr.child("Won Games").setValue(0);
            dbr.child("Lost Games").setValue(0);



            Toast.makeText(this, "Information Saved...", Toast.LENGTH_LONG).show();


        }

    }
}
