package ru.mobilesoft.piligram.repositrory.preference;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.securepreferences.SecurePreferences;

/**
 * Created on 27.01.17.
 * Преференсы, они теперь а ля secure
 */

public class PreferenceImpl implements PreferenceInterface {

    private static final String PREFERENCE_FILE = "secure_preference.xml";
    private static final String IS_FIRST_LOAD = "fL";
    private static final String TOKEN = "id";
    private static final String MSISDN = "msisdn";
    private static final String REFRESH_TOKEN = "rId";

    private final SecurePreferences preferences;

    public PreferenceImpl(Context context) {
        preferences = new SecurePreferences(context.getApplicationContext(), "", PREFERENCE_FILE);
    }

    @Override
    public boolean isFirstLoad() {

        boolean isFirst = preferences.contains(IS_FIRST_LOAD);

        if (!isFirst) {
            preferences.edit().putInt(IS_FIRST_LOAD, -1).apply();
        }

        return !isFirst;
    }

    @Override
    public String getToken() {
        return preferences.getString(TOKEN, null);
    }

    @Override
    public void setToken(String token) {
        if (TextUtils.isEmpty(token)) {
            preferences.edit().remove(TOKEN).apply();
        } else {
            preferences.edit().putString(TOKEN, token).apply();
        }
    }

    @Override
    public String getMsisdn() {
        return preferences.getString(MSISDN, null);
    }

    @Override
    public void setMsisdn(String msisdn) {
        if (TextUtils.isEmpty(msisdn)) {
            preferences.edit().remove(MSISDN).apply();
        } else {
            preferences.edit().putString(MSISDN, msisdn).apply();
        }
    }

    @Override
    public void clear() {
        preferences.edit().clear().apply();
        preferences.edit().remove(IS_FIRST_LOAD).apply();
    }

    @Override
    public String getRefreshToken() {
        return preferences.getString(REFRESH_TOKEN, null);
    }

    @Override
    public void setRefreshToken(@NonNull String refreshToken) {
        if (TextUtils.isEmpty(refreshToken)) {
            preferences.edit().remove(REFRESH_TOKEN).apply();
        } else {
            preferences.edit().putString(REFRESH_TOKEN, refreshToken).apply();
        }
    }

    @Override
    public boolean isAuth() {
        return !TextUtils.isEmpty(getToken()) && !TextUtils.isEmpty(getRefreshToken());
    }

    @Override
    public void clearToken() {
        preferences.edit().remove(TOKEN).apply();
    }
}
