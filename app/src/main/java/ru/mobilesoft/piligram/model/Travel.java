package ru.mobilesoft.piligram.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created on 9/29/17.
 */

public class Travel {

    @SerializedName("beginDate")
    private Date beginDate;

    @SerializedName("endDate")
    private Date endDate;

    @SerializedName("description")
    private String description;

    @SerializedName("img_url")
    private String image;

    @SerializedName("title")
    private String title;

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
