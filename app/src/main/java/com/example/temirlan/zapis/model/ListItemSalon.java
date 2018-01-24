package com.example.temirlan.zapis.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListItemSalon {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("checkRating")
    @Expose
    private int checkRating;
    @SerializedName("pictureUrl")
    @Expose
    private String pictureUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCheckRating() {
        return checkRating;
    }

    public void setCheckRating(int checkRating) {
        this.checkRating = checkRating;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

}