package com.example.trofeo.platzigram.login.presenter;

import android.app.Activity;

import com.example.trofeo.platzigram.login.interactor.LoginInteractor;
import com.example.trofeo.platzigram.login.interactor.LoginInteractorImpl;
import com.example.trofeo.platzigram.login.view.LoginView;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;
    private LoginInteractor interactor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        interactor = new LoginInteractorImpl(this);
    }

    @Override
    public void signIn(String username, String password, Activity activity,  FirebaseAuth firebaseAuth) {
        loginView.disableInputs();
        loginView.showProgressBar();

        interactor.signIn(username,password,activity,firebaseAuth);
    }

    @Override
    public void loginSuccess() {
        loginView.goHome();
        loginView.hideProgressBar();
    }

    @Override
    public void loginError(String error) {

        loginView.enableInputs();
        loginView.hideProgressBar();
        loginView.loginError(error);
    }
}
