package ru.mobilesoft.piligram;

import android.app.Application;

import ru.mobilesoft.piligram.model.ApiImpl;
import timber.log.Timber;

/**
 * Created by toni on 8/7/17.
 */
public class PiligramApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ApiImpl.init(this);

        if (BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }
    }

    /*
    мало ли перейдем...
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
    */
}
