package com.example.hardtaskvideo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hardtaskvideo.Interface.LoginBasePresenter;
import com.example.hardtaskvideo.Interface.LoginBaseView;
import com.example.hardtaskvideo.Interface.TaskDetailContract;
import com.example.hardtaskvideo.Presenter.LoginPresenter;
import com.wang.avi.AVLoadingIndicatorView;

import java.lang.ref.Reference;

public class MainActivity extends AppCompatActivity implements LoginBaseView {

    LoginPresenter loginPresenter;
    EditText nameEdit;
    EditText passwordEdit;
    ImageView loginButton;
    TextView registerButton;
    AVLoadingIndicatorView avLoadingIndicatorView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ui();
        init();

    }

    private void ui() {
        nameEdit = findViewById(R.id.user_name_edit);
        passwordEdit = findViewById(R.id.password_edit);
        loginButton = findViewById(R.id.login_button);
        registerButton = findViewById(R.id.register_button);
        registerButton.setSystemUiVisibility(View.INVISIBLE);
        avLoadingIndicatorView = findViewById(R.id.login_animtion);
        nameEdit.setSelection(nameEdit.getHorizontalFadingEdgeLength());
    }

    private void startlogin() {
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
        loginButton.setVisibility(View.INVISIBLE);
        avLoadingIndicatorView.setVisibility(View.VISIBLE);
        avLoadingIndicatorView.show();
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
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                avLoadingIndicatorView.setVisibility(View.INVISIBLE);
                loginButton.setVisibility(View.VISIBLE);
            }
        });
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

    @Override
    protected void onResume() {
        nameEdit.setSystemUiVisibility(View.INVISIBLE);
        super.onResume();
    }
}
