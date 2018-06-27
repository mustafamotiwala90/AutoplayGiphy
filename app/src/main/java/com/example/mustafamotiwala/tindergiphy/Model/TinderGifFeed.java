package com.example.mustafamotiwala.tindergiphy.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TinderGifFeed {

    @SerializedName("data")
    @Expose
    private List<TinderGif> data = null;

    public List<TinderGif> getData() {
        return data;
    }

    public void setData(List<TinderGif> data) {
        this.data = data;
    }
}
