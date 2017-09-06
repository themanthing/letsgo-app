package ru.mobilesoft.piligram.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * Created on 8/18/17.
 */

public class People {

    @SerializedName("name")
    private String name;

    @SerializedName("parentName")
    private String parentName;

    @SerializedName("userId")
    private String userId;

    @SerializedName("birthday")
    private Date birthday;

    @SerializedName("sex")
    private String sex;

    private List<Vacation> vacations;

    public String getName() {
        return name;
    }

    public String getParentName() {
        return parentName;
    }

    public String getUserId() {
        return userId;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getSex() {
        return sex;
    }

    public List<Vacation> getVacations() {
        return vacations;
    }
}
