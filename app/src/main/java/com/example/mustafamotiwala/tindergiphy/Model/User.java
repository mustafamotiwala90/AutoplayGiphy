package com.example.mustafamotiwala.tindergiphy.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User implements Parcelable {

    @SerializedName("avatar_url")
    @Expose
    private String _avatarUrl;

    @SerializedName("profile_url")
    @Expose
    private String _profileUrl;

    @SerializedName("username")
    @Expose
    private String _username;

    @SerializedName("display_name")
    @Expose
    private String _displayName;

    public String getAvatarUrl() {
        return _avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        _avatarUrl = avatarUrl;
    }

    public String getProfileUrl() {
        return _profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        _profileUrl = profileUrl;
    }

    public String getUsername() {
        return _username;
    }

    public void setUsername(String username) {
        _username = username;
    }

    public String getDisplayName() {
        return _displayName;
    }

    public void setDisplayName(String displayName) {
        _displayName = displayName;
    }

    protected User(Parcel in) {
        _avatarUrl = in.readString();
        _profileUrl = in.readString();
        _username = in.readString();
        _displayName = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(_avatarUrl);
        dest.writeString(_profileUrl);
        dest.writeString(_username);
        dest.writeString(_displayName);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}