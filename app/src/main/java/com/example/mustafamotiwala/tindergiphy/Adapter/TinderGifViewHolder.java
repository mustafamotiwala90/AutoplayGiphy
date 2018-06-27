package com.example.mustafamotiwala.tindergiphy.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.mustafamotiwala.tindergiphy.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TinderGifViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tinder_gif_tv)
    TextView _textView;

    @BindView(R.id.tinder_gif_iv)
    ImageView _imageView;

    @BindView(R.id.progress_bar)
    ProgressBar _progressBar;

    public TinderGifViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        _progressBar.setVisibility(View.VISIBLE);
    }

    @SuppressLint("CheckResult")
    public void setImageGifUrl(Context context, String gifUrl) {
        Glide.with(itemView.getContext())
                .asGif()
                .load(gifUrl)
                .listener(new RequestListener<GifDrawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<GifDrawable> target, boolean isFirstResource) {
                        _progressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GifDrawable resource, Object model, Target<GifDrawable> target, DataSource dataSource, boolean isFirstResource) {
                        _progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(_imageView);
    }

    public TextView getTextView() {
        return _textView;
    }

    public ImageView getImageView() {
        return _imageView;
    }
}
