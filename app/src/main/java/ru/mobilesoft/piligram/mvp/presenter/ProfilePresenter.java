package ru.mobilesoft.piligram.mvp.presenter;

import android.text.TextUtils;

import com.arellomobile.mvp.InjectViewState;

import ru.mobilesoft.piligram.model.response.People;
import ru.mobilesoft.piligram.mvp.view.MyProfileView;

/**
 * Created on 9/27/17.
 */
@InjectViewState
public class ProfilePresenter extends BasePresenter<MyProfileView> {


    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        People me = getApi().getUser();
        getViewState().showMyName(me.getName(), me.getParentName());
        getViewState().createVacationAdapter(me.getVacations());
        if (TextUtils.isEmpty(me.getAvatarUrl())) {
            getViewState().showDefaultAvatar(me.getSex());
        } else {
            getViewState().showAvatar(me.getAvatarUrl());
        }
    }

    public void openAddVacationWizard() {
        getViewState().vacationWizard();
    }

    public void editProfile() {
        getViewState().openEditProfile();
    }

    public void updateTravels() {
        People me = getApi().getUser();
        getViewState().createVacationAdapter(me.getVacations());
    }
}
