package com.example.mustafamotiwala.tindergiphy.Base;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private V _view;

    @Override
    public void onAttach(V view) {
        _view = view;
    }

    @Override
    public void detach() {
        _view = null;
    }

    @Override
    public boolean isBound() {
        return _view != null;
    }

    public V getView() {
        return _view;
    }
}
