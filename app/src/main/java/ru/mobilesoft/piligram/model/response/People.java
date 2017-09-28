package ru.mobilesoft.piligram.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ru.mobilesoft.piligram.model.Vacation;

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

    @SerializedName("avatar")
    private String avatarUrl;

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

    public void addVacation(Vacation vacation) {
        if (vacations == null){
            vacations = new ArrayList<>();
        }
        vacations.add(vacation);
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
