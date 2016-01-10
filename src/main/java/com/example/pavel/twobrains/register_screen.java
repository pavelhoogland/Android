package com.example.pavel.twobrains;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class register_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EditText inputRegiterEmail = (EditText) findViewById(R.id.emailRegisterField);
        EditText inputRegisterPassword = (EditText) findViewById(R.id.passwordRegisterField);

        String newEmail = inputRegiterEmail.getText().toString();
        String newPass= inputRegisterPassword.getText().toString();


        final Intent rd= new Intent(this,MainActivity.class);
        Button registerDone = (Button) findViewById(R.id.registerDoneButton);
        registerDone.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
               startActivity(rd);
            }
        });

    }



}
