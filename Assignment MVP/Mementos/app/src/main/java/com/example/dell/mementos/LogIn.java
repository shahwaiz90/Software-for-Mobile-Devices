package com.example.dell.mementos;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.mementos.Presenter.LoginPresenter;
import com.example.dell.mementos.Presenter.SignupPresenter;
import com.example.dell.mementos.View.LoginVInterface;

import java.util.Objects;
import java.util.regex.Pattern;

public class LogIn extends AppCompatActivity implements LoginVInterface
{
    LoginPresenter loginPresenter = new LoginPresenter(this);
    //No Model required as database has yet to be linked
    EditText email;
    EditText password;
    String pass;
    String mail;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        ActionBar bar = getSupportActionBar();
        Objects.requireNonNull(bar).hide();

        email = findViewById(R.id.email1);
        password = findViewById(R.id.password1);
    }

    @Override
    protected void onDestroy()
    {
        loginPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void validateLogin(View view)
    {
        pass = password.getText().toString();
        mail = email.getText().toString();

        if(loginPresenter.validate(mail, pass, email, password))
        {
            logIn();
        }
    }

    @Override
    public void showEmptyError(EditText ui)
    {
        ui.setError("Field must not be empty");
    }

    @Override
    public void showNotValidMailError()
    {
        email.setError("Not a valid email address");
    }

    @Override
    public void showPassLengthError()
    {
        password.setError("Min 8 characters are allowed");
    }

    @Override
    public void showPassSpaceError()
    {
        password.setError("Whitespaces not allowed");
    }

    @Override
    public void logIn()
    {
        Intent i = new Intent(LogIn.this, Home.class);
        startActivity(i);
    }
}
