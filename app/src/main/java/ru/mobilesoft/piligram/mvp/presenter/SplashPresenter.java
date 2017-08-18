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

            // надо запросить инфу по себе и продолжить
            addDisposable(getApi().getMe().subscribe(() -> {
                // а тут мы проходим дальше

                getViewState().showWelcome();

            }, throwable -> {
                // если все плохо то надо заново авторизоваться
                getViewState().showButtons();
            }));


        } else {
            // нужна авторизация
            getViewState().showButtons();

        }
    }

    public void startCreateAccount() {
        getViewState().showRegistrationView();
    }

    public void loginButtonClick() {
        getViewState().showLoginForm();
    }
}
