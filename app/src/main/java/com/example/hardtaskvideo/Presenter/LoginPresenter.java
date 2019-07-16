package com.example.hardtaskvideo.Presenter;

import com.example.hardtaskvideo.Interface.LoginBaseView;
import com.example.hardtaskvideo.Interface.LoginModel;
import com.example.hardtaskvideo.Interface.Logincallback;
import com.example.hardtaskvideo.Model.loginModleImpl;

public class LoginPresenter {
    LoginModel loginmodel;
    LoginBaseView loginBaseView;
    public LoginPresenter(LoginBaseView loginBaseView){
        this.loginBaseView = loginBaseView;
        loginmodel = new loginModleImpl();
    }
    public void addirmLogin(String s){
        loginmodel.getInfo(s, new Logincallback() {
            @Override
            public void OnScuess() {
                loginBaseView.loginScuess();
            }

            @Override
            public void OnFailed() {
                loginBaseView.passwordOrNumberError();
            }
        });
    }
}
