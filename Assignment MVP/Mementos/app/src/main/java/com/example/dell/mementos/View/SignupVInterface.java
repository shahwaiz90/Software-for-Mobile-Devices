package com.example.dell.mementos.View;

import android.view.View;
import android.widget.EditText;

public interface SignupVInterface
{
    void validate(View view);
    void showEmptyError(EditText ui);
    void showNameLengthError();
    void showNotValidMailError();
    void showPassLengthError();
    void showPassSpaceError();
    void showPassMismatchError();
    void signUp();

}
