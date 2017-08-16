package ru.mobilesoft.piligram.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;

import java.util.HashMap;

import ru.mobilesoft.piligram.mvp.view.RegistrationView;

/**
 * Created on 8/14/17.
 */
@InjectViewState
public class RegistrationPresenter extends BaseWizardPresenter<RegistrationView> {

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().initViewPager();
    }

    /**
     * собственно формирование запроса на регистрацию
     */
    public void register() {
        // пока что просто перелестнем на следующий экран
        getViewState().showSuccessScreen();
    }
}
