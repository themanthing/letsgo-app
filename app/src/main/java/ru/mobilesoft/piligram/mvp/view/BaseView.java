package ru.mobilesoft.piligram.mvp.view;

import android.support.annotation.StringRes;

import com.arellomobile.mvp.MvpView;

/**
 * Created by toni on 8/7/17.
 */

public interface BaseView extends MvpView {

    void showError(CharSequence message);

    void showPush(CharSequence title, CharSequence message);

    void requestPermission(String[] permissions, int requestCode);

    void showError(@StringRes int msgId);

    void showProgress();

    void hideProgress();
}
