package ru.mobilesoft.piligram.model;

import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

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

    @SerializedName("price")
    private Double pricePerPeople;

    @SerializedName("images")
    private List<String> images;

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

        if (TextUtils.isEmpty(image) && images != null && images.size() > 0){
            return images.get(0);
        }
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

    public Double getPrice() {
        if (pricePerPeople == null){
            return 0d;
        }
        return pricePerPeople;
    }

    public void setPrice(double pricePerPeople) {
        this.pricePerPeople = pricePerPeople;
    }
}
