package com.example.pavel.twobrains;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

   final Button signIn = (Button) findViewById(R.id.signInButton);
        final Intent i= new Intent(this, menu_screen.class);
        signIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                EditText inputEmail = (EditText) findViewById(R.id.emailField);
                EditText inputPassword = (EditText) findViewById(R.id.passwordField);
                if (inputEmail.getText().toString().equals("admin") &&
                        inputPassword.getText().toString().equals("admin")) {


                    startActivity(i);



                }

            }
        });


       final Button register = (Button) findViewById(R.id.registerButton);
        final Intent r= new Intent(this, register_screen.class);
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                startActivity(r);


            }

        });



    }



    @Override
    public void onBackPressed(){
        super.onBackPressed();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
