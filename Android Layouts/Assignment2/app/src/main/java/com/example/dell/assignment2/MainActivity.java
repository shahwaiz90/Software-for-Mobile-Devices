package com.example.dell.assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void navigate(View view)
    {
        if(view.getTag().toString().equals("1"))
        {
            intent = new Intent(this, SignUpRelative.class);
            startActivity(intent);
        }
        else if(view.getTag().toString().equals("2"))
        {
            intent = new Intent(this, SignUpConstraint.class);
            startActivity(intent);
        }
    }
}
