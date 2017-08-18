package ru.mobilesoft.piligram.repositrory.cache;

import ru.mobilesoft.piligram.model.response.People;

/**
 * Репозиторий для хранения данных в RAM (не должны сохраняться при перезапуске приложения)
 */
public class CacheRepository {
    private static volatile CacheRepository instance;

    private People me;

    public static CacheRepository getInstance() {
        if (instance == null) {
            instance = new CacheRepository();
        }
        return instance;
    }

    public People getMe() {
        return me;
    }

    public void setMe(People me) {
        this.me = me;
    }
}
