package com.example.dell.mementos;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar bar = getSupportActionBar();
        Objects.requireNonNull(bar).hide();
    }

    public void moveToSignUp(View view)
    {
        Intent i = new Intent(MainActivity.this, SignUp.class);
        startActivity(i);
    }

    public void moveToLogIn(View view)
    {
        Intent i = new Intent(MainActivity.this, LogIn.class);
        startActivity(i);
    }
}
