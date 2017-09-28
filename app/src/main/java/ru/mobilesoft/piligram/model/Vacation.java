package ru.mobilesoft.piligram.model;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created on 10.09.17.
 */

public class Vacation implements Comparable {

    @SerializedName("beginDate")
    private Date beginDate;

    @SerializedName("endDate")
    private Date endDate;

    @SerializedName("daysCount")
    private int daysCount;

    @SerializedName("type")
    private String type;

    @SerializedName("direction")
    private String direction;

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

    public int getDaysCount() {
        return daysCount;
    }

    public void setDaysCount(int daysCount) {
        this.daysCount = daysCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public int compareTo(@NonNull Object obj) {

        Vacation tmp = (Vacation) obj;
        if (this.beginDate.before(tmp.beginDate)) {
      /* текущее меньше полученного */
            return -1;
        } else if (this.beginDate.after(tmp.beginDate)) {
      /* текущее больше полученного */
            return 1;
        }
    /* текущее равно полученному */
        return 0;
    }
}
