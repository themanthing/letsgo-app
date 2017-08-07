package ru.mobilesoft.piligram.repositrory.preference;

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
    String getToken();

    /**
     * записать токен
     *
     * @param token - токен
     */
    void setToken(String token);

    /**
     * Получить номер телефона
     */
    String getMsisdn();

    /**
     * Записать номер телефона в формате 79990008811
     */
    void setMsisdn(String msisdn);

    /**
     * очистить все данные
     */
    void clear();

}
