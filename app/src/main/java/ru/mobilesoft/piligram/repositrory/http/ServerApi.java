package ru.mobilesoft.piligram.repositrory.http;

import java.util.Observable;

import io.reactivex.Maybe;
import retrofit2.http.POST;

/**
 * Created on 8/7/17.
 * retrofit server API
 */

public interface ServerApi {

    @POST("/api/registration")
    Maybe<Void> registration();



}
