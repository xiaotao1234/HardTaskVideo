package com.example.hardtaskvideo.Interface;

public interface LoginBaseView<T> {
    // 规定View必须要实现setPresenter方法，则View中保持对Presenter的引用。
    void setPresenter(T presenter);
    void releasePresenter(T presenter);
    void loginScuess();
    void loginFailed();
    void passwordOrNumberError();
}
