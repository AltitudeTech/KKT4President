package com.example.nandom.kkt4president.classes;

/**
 * Created by Nandom on 4/6/2018.
 */

public class KttTv {
    private String imageThumbnail, title;

    public KttTv() {
    }

    public KttTv( String title, String imageThumbnail) {
        this.imageThumbnail = imageThumbnail;
        this.title = title;
    }

    public String getImageThumbnail() {
        return imageThumbnail;
    }

    public void setImageThumbnail(String imageThumbnail) {
        this.imageThumbnail = imageThumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
