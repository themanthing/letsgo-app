package ru.mobilesoft.piligram.mvp.view;

/**
 * Created on 15.08.17.
 */

public interface Wizard {

    /**
     * перейти на следующий этап
     */
    void showNextStep();

    /**
     * сохранить значение
     * @param key ключ
     * @param value значение
     */
    void setValue(String key, Object value);

    /**
     * получить значение
     * @param key ключ
     * @return значение
     */
    Object getValue(String key);

}
