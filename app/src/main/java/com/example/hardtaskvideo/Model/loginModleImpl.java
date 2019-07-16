package com.example.hardtaskvideo.Model;

import com.example.hardtaskvideo.Interface.LoginModel;
import com.example.hardtaskvideo.Interface.Logincallback;

public class loginModleImpl implements LoginModel {
    @Override
    public void getInfo(String key, final Logincallback logincallback) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logincallback.OnScuess();
            }
        });
        thread.start();
    }

    @Override
    public void setInfo(String info) {

    }
}
