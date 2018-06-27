package com.example.mustafamotiwala.tindergiphy.UI;

import com.example.mustafamotiwala.tindergiphy.Base.MvpView;
import com.example.mustafamotiwala.tindergiphy.Model.TinderGif;

import java.util.List;

public interface GiphyFeedView extends MvpView {

    void showContent(List<TinderGif> items);

    void appendContent(List<TinderGif> nextPageItems);
}

