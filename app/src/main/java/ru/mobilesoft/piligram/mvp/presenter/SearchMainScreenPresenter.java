package ru.mobilesoft.piligram.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;

import ru.mobilesoft.piligram.mvp.view.SearchMainScreenView;

/**
 * Created on 8/10/17.
 */
@InjectViewState
public class SearchMainScreenPresenter extends BasePresenter<SearchMainScreenView> {

    public void showPeopleTab() {
        getViewState().setCurrentTab(2);
    }

    public void showTravelsTab() {
        getViewState().setCurrentTab(1);
    }


}
