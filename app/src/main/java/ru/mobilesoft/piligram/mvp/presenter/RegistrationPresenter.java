package ru.mobilesoft.piligram.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;

import ru.mobilesoft.piligram.mvp.view.RegistrationView;

/**
 * Created on 8/14/17.
 */
@InjectViewState
public class RegistrationPresenter extends BasePresenter<RegistrationView> {

    /**
     * собственно формирование запроса на регистрацию
     */
    public void register() {
        //TODO пока что просто перелестнем на следующий экран
        getViewState().showSuccessScreen();
    }
}
