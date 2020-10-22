package com.professionaldream.professionality.data.model;

import android.net.Uri;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private String userId;
    private String displayName;//Nome+Cognome
    private String email;
    private Uri photoUrl;

    public LoggedInUser(String userId, String displayName,String email,Uri photoUrl) {
        this.userId = userId;
        this.displayName = displayName;
        this.email=email;
        this.photoUrl=photoUrl;
    }

    @Override
    public String toString() {
        return "LoggedInUser{" +
                "userId='" + userId + '\'' +
                ", displayName='" + displayName + '\'' +
                ", email='" + email + '\'' +
                ", photoUrl=" + photoUrl +
                '}';
    }

    public Uri getPhotoUrl() {
        return photoUrl;
    }

    public String getEmail() {
        return email;
    }

    public String getUserId() {
        return userId;
    }

    public String getDisplayName() {
        return displayName;
    }
}