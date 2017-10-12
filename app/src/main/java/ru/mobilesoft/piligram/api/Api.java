package ru.mobilesoft.piligram.api;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import ru.mobilesoft.piligram.model.Travel;
import ru.mobilesoft.piligram.model.response.People;

/**
 * Created on 8/7/17.
 */

public interface Api {

    /**
     * проверит авторизовывались ли мы ранее
     *
     * @return Ежели мы были авторизованны ранее то true
     */
    boolean isAuth();

    /**
     * получить токен для запросов к серверу
     *
     * @return токен
     */
    String getToken();

    /**
     * получить refresh token для авторизации в слепую
     *
     * @return токен
     */
    String getRefreshToken();

    /**
     * Авторизация по логину и паролю
     *
     * @param userName логин
     * @param password пароль
     * @return вернет мои данные, или ошибку
     */
    Completable auth(String userName, String password);

    /**
     * перегенерация токена auth_token при помощи refresh
     *
     * @return вернет все ок, или ошибку
     */
    Completable refreshToken();

    /**
     * получить данные по себе
     * TODO нужно сразу все данные получать, чего тянуть то
     *
     * @return вернет все данные обо мне
     */
    Observable<People> getMe();

    /**
     * добавить отпуск
     *
     * @param values
     * @return
     */
    Completable addVacation(HashMap<String, Object> values);

    /**
     * получить мои данные из кеша
     *
     * @return
     */
    People getUser();

    /**
     * создать путешествие
     *
     * @param travel
     * @return
     */
    Completable createTravel(Travel travel);

    /**
     * Получить список поездок
     * @param page страница
     * @return вернет массив поездок
     */
    Observable<List<Travel>> getTravelList(int page);

    /**
     * список моих
     * @return
     */
    Observable<List<Travel>> getMyTravels();
}
