package ru.mobilesoft.piligram.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

/**
 * Created on 8/16/17.
 * сервис отправки картинки на сервер
 */

public class UploadImageService extends IntentService {

    public UploadImageService() {
        super(UploadImageService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }
}
