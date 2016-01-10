package com.example.pavel.twobrains;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class menu_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final Intent mf = new Intent(this, matchfinder_screen.class);
        Button mfButton = (Button) findViewById(R.id.matchfinderButton);
        mfButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(mf);
            }
        });

        final Intent ma = new Intent(this, matches_screen.class);
        Button maButton = (Button) findViewById(R.id.matchButton);
        maButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(ma);
            }
        });
    }

}
