package com.example.mustafamotiwala.tindergiphy.Presenter;

import com.example.mustafamotiwala.tindergiphy.Base.MvpPresenter;
import com.example.mustafamotiwala.tindergiphy.UI.GiphyFeedView;

public interface ImageGridContract<V extends GiphyFeedView> extends MvpPresenter<V> {

    void showContent();

    void loadMore(int offset);
}