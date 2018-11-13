package com.example.dell.mementos.Presenter;

import android.widget.EditText;

import com.example.dell.mementos.View.LoginVInterface;

import java.util.regex.Pattern;

public class LoginPresenter implements LoginPInterface
{
    private LoginVInterface loginView;
    //No Model required as database has yet to be linked

    public LoginPresenter(LoginVInterface loginView)
    {
        this.loginView = loginView;
    }

    @Override
    public boolean validate(String mail, String pass, EditText m, EditText p)
    {
        int flag = 0;

        //email
        if (mail.isEmpty())
        {
            loginView.showEmptyError(m);
            flag = 1;
        }
        else if (!Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$").matcher(mail).find())
        {
            loginView.showNotValidMailError();
            flag = 1;
        }

        //password
        if (pass.isEmpty())
        {
            loginView.showEmptyError(p);
            flag = 1;
        }
        else if (pass.length() < 8)
        {
            loginView.showPassLengthError();
            flag = 1;
        }
        else if ((Pattern.compile("[\\s]").matcher(pass).find()))
        {
            loginView.showPassSpaceError();
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
        loginView = null;
    }
}
