package ru.mobilesoft.piligram.model;

import java.util.Date;

/**
 * Created on 10.09.17.
 */

public class Vacation {

    private Date beginDate;

    private Date endDate;

    private int daysCount;

    private String type;

    private String direction;

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setDaysCount(int daysCount) {
        this.daysCount = daysCount;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
