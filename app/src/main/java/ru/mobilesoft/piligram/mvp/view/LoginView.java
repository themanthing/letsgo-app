package ru.mobilesoft.piligram.mvp.view;

/**
 * Created on 8/18/17.
 */

public interface LoginView  extends BaseView {

    void showEmailValidationError();

    void showPasswordError();

    void showSuccess();

    void showAuthError();
}
