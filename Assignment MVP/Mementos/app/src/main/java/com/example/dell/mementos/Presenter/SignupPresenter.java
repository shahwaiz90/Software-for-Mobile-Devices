package com.example.dell.mementos.Presenter;

import android.widget.EditText;

import com.example.dell.mementos.View.SignupVInterface;

import java.util.regex.Pattern;

public class SignupPresenter implements SignupPInterface
{

    private SignupVInterface signupView;
    //No Model required as database has yet to be linked

    public SignupPresenter(SignupVInterface signupView)
    {
        this.signupView = signupView;
    }

    @Override
    public boolean validate(String mail, String name, String pass, String conf, EditText m, EditText n, EditText p, EditText c)
    {
        int flag = 0;
        //fullname
        if (name.isEmpty())
        {
            signupView.showEmptyError(n);
            flag = 1;
        }
        else if (name.length() > 30)
        {
            signupView.showNameLengthError();
            flag = 1;
        }

        //email
        if (mail.isEmpty())
        {
            signupView.showEmptyError(m);
            flag = 1;
        }
        else if (!Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$").matcher(mail).find())
        {
            signupView.showNotValidMailError();
            flag = 1;
        }

        //password
        if (pass.isEmpty())
        {
            signupView.showEmptyError(p);
            flag = 1;
        }
        else if (pass.length() < 8)
        {
            signupView.showPassLengthError();
            flag = 1;
        }
        else if ((Pattern.compile("[\\s]").matcher(pass).find()))
        {
            signupView.showPassSpaceError();
            flag = 1;
        }

        //confirm password
        if (conf.isEmpty())
        {
            signupView.showEmptyError(c);
            flag = 1;
        }
        else if (!conf.equals(pass))
        {
            signupView.showPassMismatchError();
            flag = 1;
        }

        if(flag == 1)
        {
            return  false;
        }
        return true;
    }

    public void onDestroy()
    {
        signupView = null;
    }
}
