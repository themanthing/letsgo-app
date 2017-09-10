package ru.mobilesoft.piligram.model.request;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created on 8/18/17.
 * отправка данных на сервер регистрации
 */

public class RegistrationRequest {

    @SerializedName("username")
    private String email;

    @SerializedName("password")
    private String password;

    @SerializedName("birthday")
    private Date birthday;

    @SerializedName("name")
    private String name;

    @SerializedName("parentName")
    private String parentName;

    @SerializedName("sex")
    private String sex;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
