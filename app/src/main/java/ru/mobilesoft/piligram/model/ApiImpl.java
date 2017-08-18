package ru.mobilesoft.piligram.model;

import android.content.Context;

import ru.mobilesoft.piligram.repositrory.http.RetrofitApi;
import ru.mobilesoft.piligram.repositrory.http.ServerApi;
import ru.mobilesoft.piligram.repositrory.preference.PreferenceImpl;
import ru.mobilesoft.piligram.repositrory.preference.PreferenceInterface;

/**
 * Created on 8/7/17.
 */

public class ApiImpl implements Api {

    private static Api api;
    private PreferenceInterface preference;
    private ServerApi http;

    private ApiImpl(Context context) {
        this.preference = new PreferenceImpl(context);
        this.http = RetrofitApi.getServerApi();
        //this.db = new DatabaseApiImpl();
    }

    public static void init(Context context) {
        api = new ApiImpl(context);
    }


    public static Api getInstance() {
        return api;
    }

    @Override
    public boolean isAuth() {
        return preference.isAuth();
    }
}
