package com.example.dell.mementos.Presenter;

import android.widget.EditText;

public interface SignupPInterface
{
    boolean validate(String mail, String fullname, String pass, String confirm, EditText m, EditText n, EditText p, EditText c);
}
