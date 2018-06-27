package com.example.mustafamotiwala.tindergiphy.Base;

import android.support.annotation.NonNull;

public interface MvpView {

    void showLoading();

    void hideLoading();

    void showMessage(@NonNull String message);
}
