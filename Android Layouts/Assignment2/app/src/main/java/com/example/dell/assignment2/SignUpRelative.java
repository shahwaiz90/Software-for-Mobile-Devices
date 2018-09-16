package com.example.dell.assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SignUpRelative extends AppCompatActivity
{

    EditText email;
    EditText pass;
    RadioGroup radioGroup;
    RadioButton radioButton;
    CheckBox terms;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_relative);
    }

    public boolean validate()
    {
        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        radioGroup = findViewById(R.id.genderGroup);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton =  findViewById(selectedId);
        terms = findViewById(R.id.terms);

        int fail = 0;

        if(email.getText().toString().equals(""))
        {
            Toast.makeText(this, "Email is missing", Toast.LENGTH_SHORT).show();
            fail = 1;
        }
        else if(pass.getText().toString().equals(""))
        {
            Toast.makeText(this, "Password is missing", Toast.LENGTH_SHORT).show();
            fail = 1;
        }
        else if(radioGroup.getCheckedRadioButtonId() == -1)
        {
            Toast.makeText(this, "Gender is not selected", Toast.LENGTH_SHORT).show();
            fail = 1;
        }
        else if(!terms.isChecked())
        {
            Toast.makeText(this, "Terms and Conditions are not checked", Toast.LENGTH_SHORT).show();
            fail = 1;
        }

        if(fail == 1)
        {
            return false;
        }
        return true;

    }

    public void register(View view)
    {
        if(validate())
        {
            Toast.makeText(this, "E-mail: "+email.getText()+" | "+"Password: "+pass.getText()+" | "+"Gender: "+radioButton.getText()+" | "+"Terms: "+"Checked", Toast.LENGTH_SHORT).show();
        }

    }
}
