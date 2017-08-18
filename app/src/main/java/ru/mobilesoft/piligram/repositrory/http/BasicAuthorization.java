package ru.mobilesoft.piligram.repositrory.http;

import android.util.Base64;
import android.util.Log;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import ru.mobilesoft.piligram.BuildConfig;

/**
 * базовая авторизация, наш сервер это как родное считает
 */

class BasicAuthorization implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Log.d("BasicAuthorization", "BuildConfig.AUTH = " + BuildConfig.AUTH);

        // вот это еще в заголовок нужно подать "Authorization: Bearer 123456789"

        Request original = chain.request();
        final String basic =
                "Basic " + Base64.encodeToString(BuildConfig.AUTH.getBytes(Charset.defaultCharset()),
                                                 Base64.NO_WRAP);

        Request.Builder requestBuilder = original.newBuilder()
                .header("Authorization", basic)
                .header("Accept", "application/json")
                .header("App_version", BuildConfig.VERSION)
                .method(original.method(), original.body());

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}