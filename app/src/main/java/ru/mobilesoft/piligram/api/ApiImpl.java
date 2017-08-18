package ru.mobilesoft.piligram.api;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import ru.mobilesoft.piligram.model.request.AuthRequest;
import ru.mobilesoft.piligram.model.response.TokenResponse;
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

    @Override
    public String getToken() {
        return preference.getToken();
    }

    @Override
    public String getRefreshToken() {
        return preference.getRefreshToken();
    }

    @Override
    public Completable auth(String userName, String password) {

        AuthRequest authRequest = new AuthRequest(userName, password);
        authRequest.setClientId("android");
        authRequest.setClientPassword("SomeRandomCharsAndNumbers");
        return Completable.fromObservable(http.singIn(authRequest).flatMap(new Function<TokenResponse, ObservableSource<Void>>() {
            @Override
            public ObservableSource<Void> apply(TokenResponse tokenResponse) throws Exception {

                return Observable.empty();
            }
        })
                                                  .observeOn(AndroidSchedulers.mainThread())
                                                  .delaySubscription(400, TimeUnit.MILLISECONDS,
                                                                     AndroidSchedulers.mainThread()));
    }
}
