package ru.mobilesoft.piligram.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;

import retrofit2.HttpException;
import retrofit2.Response;
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
            // мы авторизовывались ранее
            // сразу рефрешим токен) что бы никто кроме нас, мало ли осталось от токена пара секунд,
            // не хочется постоянно с ним бороться)
            addDisposable(getApi().refreshToken().subscribe(() -> {
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
