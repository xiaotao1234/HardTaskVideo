package com.example.hardtaskvideo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hardtaskvideo.Interface.LoginBasePresenter;
import com.example.hardtaskvideo.Interface.LoginBaseView;
import com.example.hardtaskvideo.Interface.TaskDetailContract;
import com.example.hardtaskvideo.Presenter.LoginPresenter;

import java.lang.ref.Reference;

public class MainActivity extends AppCompatActivity implements LoginBaseView {

    LoginPresenter loginPresenter;
    EditText nameEdit;
    EditText passwordEdit;
    Button loginButton;
    Button registerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        ui();
    }

    private void ui() {
        nameEdit = findViewById(R.id.user_name_edit);
        passwordEdit = findViewById(R.id.password_edit);
        loginButton = findViewById(R.id.login_button);
        registerButton = findViewById(R.id.register_button);
    }

    private void startlogin() {
        if(loginPresenter!=null){
            String key = passwordEdit+"\n"+nameEdit;
            loginPresenter.addirmLogin(key);
        }
    }

    private void init() {
        loginPresenter = new LoginPresenter(this);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startlogin();
            }
        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beginNewActivity(RegisterActivity.class);
            }
        });
    }


    @Override
    public void setPresenter(Object presenter) {

    }

    @Override
    public void releasePresenter(Object presenter) {

    }

    @Override
    public void loginScuess() {
        beginNewActivity(MainUserActivity.class);
    }

    @Override
    public void loginFailed() {
        Toast.makeText(this,"账号或密码错误",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void passwordOrNumberError() {

    }

    private void beginNewActivity(Class clz){
        Intent intent = new Intent(MainActivity.this,clz);
        startActivity(intent);
    }
}
