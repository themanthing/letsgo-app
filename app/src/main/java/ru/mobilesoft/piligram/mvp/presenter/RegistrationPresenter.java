package ru.mobilesoft.piligram.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;

import ru.mobilesoft.piligram.mvp.view.RegistrationView;

/**
 * Created on 8/14/17.
 */
@InjectViewState
public class RegistrationPresenter extends BasePresenter<RegistrationView> {



    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().initViewPager();
    }


}
