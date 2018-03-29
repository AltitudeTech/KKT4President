package com.example.nandom.kkt4president.classes;

/**
 * Created by Nandom on 3/21/2018.
 */

public class News {
    private int id;
    private String title;
    private String link;
    private String date;
    private String brief;

    public News(){

    }

    public News(int id, String title, String link, String date, String brief) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.date = date;
        this.brief = brief;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }
}
