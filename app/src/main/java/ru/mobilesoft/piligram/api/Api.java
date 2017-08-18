package ru.mobilesoft.piligram.api;

import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * Created on 8/7/17.
 */

public interface Api {

    /**
     * проверит авторизовывались ли мы ранее
     * @return Ежели мы были авторизованны ранее то true
     */
    boolean isAuth();

    /**
     * получить токен для запросов к серверу
     * @return токен
     */
    String getToken();

    /**
     * получить refresh token для авторизации в слепую
     * @return токен
     */
    String getRefreshToken();

    /**
     * Авторизация по логину и паролю
     * @param userName
     * @param password
     * @return
     */
    Completable auth(String userName, String password);



}
