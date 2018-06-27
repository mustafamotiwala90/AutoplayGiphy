package com.example.mustafamotiwala.tindergiphy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mustafamotiwala.tindergiphy.Model.Original;
import com.example.mustafamotiwala.tindergiphy.Model.User;
import com.example.mustafamotiwala.tindergiphy.Utils.StringUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GifDetailActivity extends AppCompatActivity{

    @BindView(R.id.gif_detailed_view)
    ImageView _largeGifView;

    @BindView(R.id.gif_title)
    TextView _titleView;

    @BindView(R.id.user_profile_iv)
    ImageView _userImageView;

    @BindView(R.id.user_profile_tv)
    TextView _userProfileTextView;

    Original gifModel;

    User _userModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_view);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        gifModel = intent.getParcelableExtra(StringUtils.EXTRA_ORIGINAL_MODEL);
        _userModel = intent.getParcelableExtra(StringUtils.EXTRA_USER);
        showGif();
        showUserData();
    }

    @SuppressLint("SetTextI18n")
    private void showUserData() {
        Glide.with(this)
                .load(_userModel.getAvatarUrl())
                .into(_userImageView);
        _userProfileTextView.setText(getString(R.string.user_posted_by) + _userModel.getDisplayName());
    }

    public void showGif() {
        Glide.with(this)
                .asGif()
                .load(gifModel.getUrl())
                .into(_largeGifView);
    }
}
