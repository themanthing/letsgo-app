package ru.mobilesoft.piligram.model;

import android.content.Context;

/**
 * Created by toni on 8/7/17.
 */

public class ApiImpl implements Api {

    private static Api api;
    //private PreferenceInterface preference;

    private ApiImpl(Context context) {
        //this.preference = new PreferenceImpl(context);
        //this.http = RetrofitApi.getServerApi();
        //this.db = new DatabaseApiImpl();
    }

    public static void init(Context context) {
        api = new ApiImpl(context);
    }


    public static Api getInstance() {
        return api;
    }
}
