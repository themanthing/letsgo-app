package ru.mobilesoft.piligram.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;

import java.util.HashMap;

import ru.mobilesoft.piligram.mvp.view.RegistrationView;

/**
 * Created on 8/14/17.
 */
@InjectViewState
public class RegistrationPresenter extends BasePresenter<RegistrationView> {

    private HashMap<String, Object> wizardParam = new HashMap<>();

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().initViewPager();
    }



}
