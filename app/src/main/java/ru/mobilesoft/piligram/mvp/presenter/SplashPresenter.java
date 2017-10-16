package ru.mobilesoft.piligram.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;

import io.reactivex.Observable;
import ru.mobilesoft.piligram.mvp.view.SplashView;
import timber.log.Timber;

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
                Timber.d("успещгл авторизовались");
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

    public void checkUserData() {

        // TODO обработка ошибок!
        addDisposable(Observable.zip(getApi().getMe(),
                                     getApi().getTravelList(0),
                                     getApi().getMyTravels(),
                                     getApi().getPeople(0),
                                     (t1, t2, t3, t4) -> t1)
                              .subscribe(me -> {
                                  if (me.getVacations() == null || me.getVacations().isEmpty()) {
                                      // нужно попробоать предложить задать отпуск
                                      getViewState().showAddVacation();
                                  } else {
                                      getViewState().showMainScreen();
                                  }
                              }, Timber::e));
    }

    /**
     * ну наконец-то доберемся до главного экрана
     */

    public void skipVacation() {
        getViewState().showMainScreen();
    }
}
