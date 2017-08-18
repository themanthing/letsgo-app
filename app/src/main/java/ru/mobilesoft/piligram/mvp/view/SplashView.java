package ru.mobilesoft.piligram.mvp.view;

/**
 * Created on 8/14/17.
 */

public interface SplashView extends BaseView {

    /**
     * показать окошко регистрации
     */
    void showRegistrationView();

    /**
     * показать окошко авторизации
     */
    void showLoginForm();

    /**
     * показат кнопки
     */
    void showButtons();

    /**
     * показывает приветствие и загружает остальные данные
     */
    void showWelcome();
}
