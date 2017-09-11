package ru.mobilesoft.piligram.mvp.view;

import android.support.annotation.Nullable;

import com.arellomobile.mvp.MvpView;

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
    @Nullable
    Object getValue(String key);

    /**
     * проверка наличия ключа
     * @param name имя ключа
     * @return true если есть
     */
    boolean containsKey(String name);

    int getInt(String travelType);
}
