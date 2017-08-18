package ru.mobilesoft.piligram.mvp.presenter;

import android.text.TextUtils;

import com.arellomobile.mvp.InjectViewState;

import ru.mobilesoft.piligram.mvp.view.LoginView;
import ru.mobilesoft.piligram.utils.ValidateUtils;

/**
 * Created on 8/18/17.
 */

@InjectViewState
public class LoginPresenter extends BasePresenter<LoginView> {

    public void login(String email, String password) {

        if (!ValidateUtils.validateEmail(email)) {
            getViewState().showEmailValidationError();
            return;
        }

        if (TextUtils.isEmpty(password) || password.length() < 5) {
            getViewState().showPasswordError();
            return;
        }

        getViewState().showProgress();
        addDisposable(getApi().auth(email, password).subscribe(() -> {
            getViewState().showSuccess();
        }, throwable -> {
            getViewState().hideProgress();
            getViewState().showAuthError();
        }));

    }
}
