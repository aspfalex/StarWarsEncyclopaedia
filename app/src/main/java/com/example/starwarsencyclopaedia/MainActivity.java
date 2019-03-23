package com.example.starwarsencyclopaedia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startSWE(View view){
        // Create an Intent to start the second activity
        Intent randomIntent = new Intent(this, SecondActivity.class);

        // Start the new activity.
        startActivity(randomIntent);
    }
}
