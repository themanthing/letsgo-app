package ru.mobilesoft.piligram.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;

import ru.mobilesoft.piligram.mvp.view.SplashView;

/**
 * Created on 8/14/17.
 */

@InjectViewState
public class SplashPresenter extends BasePresenter<SplashView> {

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        if (getApi().isAuth()) {
            // мы авторизовались ранее, надо подкачать все что нужно и топать на главный экран
        } else {
            // нужна авторизация

        }
    }

    public void startCreateAccount() {
        getViewState().showRegistrationView();
    }

    public void loginButtonClick() {
        getViewState().showLoginForm();
    }
}
