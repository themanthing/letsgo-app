package ru.mobilesoft.piligram.api;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import ru.mobilesoft.piligram.model.request.AuthRequest;
import ru.mobilesoft.piligram.model.response.People;
import ru.mobilesoft.piligram.repositrory.cache.CacheRepository;
import ru.mobilesoft.piligram.repositrory.http.RetrofitApi;
import ru.mobilesoft.piligram.repositrory.http.ServerApi;
import ru.mobilesoft.piligram.repositrory.preference.PreferenceImpl;
import ru.mobilesoft.piligram.repositrory.preference.PreferenceInterface;

/**
 * Created on 8/7/17.
 * TODO поведение системы должно быть таким при получении 401 мы переходим на главный SplashScreen
 * причем если у нас протух только access_token то его нужно попробовать переполучить через refresh_token
 * и в случае неудачи только переходить на страницу SpleshScreen причем надо будет делать повтор последнего запроса
 * т.е. repeat но это пока теория...
 */

public class ApiImpl implements Api {

    private static Api api;
    private PreferenceInterface preference;
    private ServerApi http;
    private CacheRepository cache;

    private ApiImpl(Context context) {
        this.preference = new PreferenceImpl(context);
        this.http = RetrofitApi.getServerApi();
        this.cache = CacheRepository.getInstance();
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

        return http.singIn(authRequest)
                .delay(1, TimeUnit.SECONDS)
                .flatMapCompletable(tokenResponse -> {
                    preference.setToken(tokenResponse.getAccessToken());
                    preference.setRefreshToken(tokenResponse.getRefreshToken());
                    return CompletableObserver::onComplete;
                })
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<People> getMe() {
        return http.getMy()
                .doOnNext(people -> cache.setMe(people))
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Completable refreshToken() {
        preference.clearToken();
        AuthRequest authRequest = new AuthRequest(preference.getRefreshToken());
        authRequest.setClientId("android");
        authRequest.setClientPassword("SomeRandomCharsAndNumbers");
        return http.singIn(authRequest)
                .delay(1, TimeUnit.SECONDS)
                .flatMapCompletable(tokenResponse -> {
                    preference.setToken(tokenResponse.getAccessToken());
                    preference.setRefreshToken(tokenResponse.getRefreshToken());
                    return CompletableObserver::onComplete;
                })
                .observeOn(AndroidSchedulers.mainThread());
    }
}
