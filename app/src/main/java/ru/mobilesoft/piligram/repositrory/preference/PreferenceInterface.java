package ru.mobilesoft.piligram.repositrory.preference;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Createdв on 27.01.17.
 * Интрефейс работы с преференсами
 */

public interface PreferenceInterface {

    /**
     * первый ли это запуск прилоежния
     *
     * @return true - если первый, false иначе
     */
    boolean isFirstLoad();

    /**
     * получить токен
     *
     * @return токен
     */
    @Nullable
    String getToken();

    /**
     * записать токен
     *
     * @param token - токен
     */
    void setToken(@NonNull String token);

    /**
     * Получить номер телефона
     */
    @Nullable
    String getMsisdn();

    /**
     * Записать номер телефона в формате 79990008811
     */
    void setMsisdn(String msisdn);

    /**
     * очистить все данные
     */
    void clear();

    /**
     * получить RefreshToken
     *
     * @return refreshToken
     */
    @Nullable
    String getRefreshToken();

    /**
     * сохранить refreshToken
     *
     * @param refreshToken -токен
     */
    void setRefreshToken(@NonNull String refreshToken);

    /**
     * проверит авторизовывались ли мы ранее
     * @return true если была авторизация ранее
     */
    boolean isAuth();

    /**
     * почистим auth_token он устарел
     */
    void clearToken();
}
