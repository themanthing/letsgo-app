package ru.mobilesoft.piligram.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;

import ru.mobilesoft.piligram.mvp.view.FinishRegView;

/**
 * Created on 9/6/17.
 */
@InjectViewState
public class FinishRegPresenter extends BasePresenter<FinishRegView> {

    public void skip() {
        getViewState().showMainScreen();
    }

    public void addVacation() {
        getViewState().showAddVacationWizard();
    }
}
