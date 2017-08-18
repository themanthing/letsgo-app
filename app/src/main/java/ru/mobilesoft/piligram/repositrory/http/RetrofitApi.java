package ru.mobilesoft.piligram.repositrory.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mobilesoft.piligram.BuildConfig;

/**
 * Created on 27.01.17.
 * стандартный класс для работы с нашим сервером
 */

public class RetrofitApi {

    // таймаут в минутах для обращения к серверу
    private static final int READ_TIMEOUT = 3;

    public static ServerApi getServerApi() {

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                /*.registerTypeAdapter(new TypeToken<RealmList<RealmString>>() {
                }.getType(), new RealmListConverter())*/
                .setPrettyPrinting()
                .create();

        RxJava2CallAdapterFactory rxAdapter = RxJava2CallAdapterFactory
                .createWithScheduler(Schedulers.io());

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.addInterceptor(new BasicAuthorization());

        if (BuildConfig.DEBUG) {
            httpClient.addInterceptor(new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY));
        } else {
            httpClient.addInterceptor(new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.NONE));
        }

        httpClient.connectTimeout(READ_TIMEOUT, TimeUnit.MINUTES);
        httpClient.readTimeout(READ_TIMEOUT, TimeUnit.MINUTES);

        /**
         * ssl-pinning example
         * httpClient.certificatePinner(new CertificatePinner.Builder().add().build());
         */

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(rxAdapter)
                .client(httpClient.build())
                .build();

        return retrofit.create(ServerApi.class);
    }

}
