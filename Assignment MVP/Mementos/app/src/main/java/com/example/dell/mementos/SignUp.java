package com.example.dell.mementos;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.dell.mementos.Presenter.SignupPresenter;
import com.example.dell.mementos.View.SignupVInterface;

import java.util.Objects;
import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity implements SignupVInterface
{

    SignupPresenter signupPresenter = new SignupPresenter(this);
    //No Model required as database has yet to be linked
    EditText fullname;
    EditText email;
    EditText password;
    EditText confirm;
    String name;
    String pass;
    String conf;
    String mail;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ActionBar bar = getSupportActionBar();
        Objects.requireNonNull(bar).hide();

        fullname = findViewById(R.id.fullname);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirm = findViewById(R.id.confirm);

    }

    @Override
    protected void onDestroy()
    {
        signupPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void validate(View view)
    {
        name = fullname.getText().toString();
        pass = password.getText().toString();
        conf = confirm.getText().toString();
        mail = email.getText().toString();

        if(signupPresenter.validate(mail, name, pass, conf, email, fullname, password, confirm))
        {
            signUp();
        }
    }

    @Override
    public void showEmptyError(EditText ui)
    {
        ui.setError("Field must not be empty");
    }

    @Override
    public void showNameLengthError()
    {
        fullname.setError("Max 30 characters are allowed");
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
    public void showPassMismatchError()
    {
        confirm.setError("Password does not match");
    }

    @Override
    public void signUp()
    {
        Intent i = new Intent(SignUp.this, Home.class);
        startActivity(i);
    }


}
