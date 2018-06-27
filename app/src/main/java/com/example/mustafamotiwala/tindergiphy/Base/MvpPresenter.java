package com.example.mustafamotiwala.tindergiphy.Base;

public interface MvpPresenter<V extends MvpView> {

    void onAttach(V view);

    void detach();

    boolean isBound();
}
