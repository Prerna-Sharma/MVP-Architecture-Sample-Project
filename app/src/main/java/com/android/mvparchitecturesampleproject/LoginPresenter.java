package com.android.mvparchitecturesampleproject;

import android.text.TextUtils;

/**
 * Implementation of presenter
 * <p>
 * Created by Prerna Sharma on 5/16/2017.
 */

public class LoginPresenter implements MVP_Main.PresenterOperations {
    private MVP_Main.ViewOperations loginView;

    LoginPresenter(MVP_Main.ViewOperations loginView) {
        this.loginView = loginView;
    }

    @Override
    public void getLogin(String username, String password) {
        if (TextUtils.isEmpty(username) && TextUtils.isEmpty(password)) {
            loginView.showToast();
        } else {
            if (username.equals("name") && password.equals("pass")) {
                loginView.loginSuccess();
            } else {
                loginView.loginFailed();
            }
        }
    }
}
