package ru.mobilesoft.piligram.mvp.view;

/**
 * Created on 8/14/17.
 */

public interface RegistrationView extends BaseView {

    /**
     * инициализация VP и адаптера
     */
    void initViewPager();

    /**
     * покажем успех (а это просто последний экран)
     */
    void showSuccessScreen();
}
