package ru.mobilesoft.piligram.model.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created on 8/18/17.
 * запрос на авторизацию
 */

public class AuthRequest {

    @SerializedName("username")
    private String email;

    @SerializedName("password")
    private String password;

    @SerializedName("grant_type")
    private String grandType;

    @SerializedName("client_id")
    private String clientId;

    @SerializedName("client_secret")
    private String clientPassword;

    @SerializedName("refresh_token")
    private String refreshToken;

    public AuthRequest(String userName, String password) {
        email = userName;
        this.password = password;
        grandType = "password";
    }

    public AuthRequest(String refreshToken) {
        this.refreshToken = refreshToken;
        grandType = "refresh_token";
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setClientPassword(String clientPassword) {
        this.clientPassword = clientPassword;
    }
}
