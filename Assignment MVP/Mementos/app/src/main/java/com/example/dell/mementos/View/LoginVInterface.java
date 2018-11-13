package com.example.dell.mementos.View;

import android.view.View;
import android.widget.EditText;

public interface LoginVInterface
{
    void validateLogin(View view);
    void showEmptyError(EditText ui);
    void showNotValidMailError();
    void showPassLengthError();
    void showPassSpaceError();
    void logIn();
}
