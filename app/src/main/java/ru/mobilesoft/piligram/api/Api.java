package ru.mobilesoft.piligram.api;

import io.reactivex.Completable;
import io.reactivex.Observable;
import ru.mobilesoft.piligram.model.response.People;

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
     * @param userName логин
     * @param password пароль
     * @return вернет мои данные, или ошибку
     */
    Completable auth(String userName, String password);

    /**
     * получить данные по себе
     * @return
     */
    Completable getMe();



}
