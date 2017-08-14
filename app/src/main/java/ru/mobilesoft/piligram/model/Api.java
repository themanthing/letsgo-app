package ru.mobilesoft.piligram.model;

/**
 * Created on 8/7/17.
 */

public interface Api {

    /**
     * проверит авторизовывались ли мы ранее
     * @return Ежели мы были авторизованны ранее то true
     */
    boolean isAuth();
}
