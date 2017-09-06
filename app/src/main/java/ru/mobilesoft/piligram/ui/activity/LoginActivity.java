package ru.mobilesoft.piligram.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;

import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.OnClick;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.mvp.presenter.LoginPresenter;
import ru.mobilesoft.piligram.mvp.view.LoginView;
import ru.mobilesoft.piligram.utils.SimpleTextWatcher;
import su.ias.components.progress.ProgressButtonView;

/**
 * Created on 8/14/17.
 * Страница с вводом логина и пароля
 */

public class LoginActivity extends BaseActivity implements LoginView {

    @InjectPresenter
    LoginPresenter presenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.ed_password)
    EditText password;

    @BindView(R.id.ed_email)
    EditText email;

    @BindView(R.id.ti_email_layout)
    TextInputLayout emailLayout;

    @BindView(R.id.ti_password_layout)
    TextInputLayout passwordLayout;

    @BindView(R.id.btn_action)
    ProgressButtonView progressButtonView;

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
        email.addTextChangedListener(new SimpleTextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
                emailLayout.setErrorEnabled(false);
                checkButtonEnabled();
            }
        });

        password.addTextChangedListener(new SimpleTextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
                passwordLayout.setErrorEnabled(false);
                checkButtonEnabled();
            }
        });

    }

    private void checkButtonEnabled() {
        progressButtonView.setEnabled(!TextUtils.isEmpty(email.getText()) && !TextUtils.isEmpty(
                password.getText()));
    }

    @OnClick(R.id.btn_action)
    void onEnterButtonClick() {
        presenter.login(email.getText().toString(), password.getText().toString());

    }

    @OnClick(R.id.tv_remember_password)
    void onRememberPasswordClick() {

    }

    @Override
    public void showEmailValidationError() {
        emailLayout.setError(getString(R.string.error_incorrect_email));
        emailLayout.setErrorEnabled(true);
    }

    @Override
    public void showPasswordError() {
        passwordLayout.setError(getString(R.string.error_password_length));
        passwordLayout.setErrorEnabled(true);
    }

    @Override
    public void showProgress() {
        showLockScreen();
        progressButtonView.showProgress();
    }

    @Override
    public void hideProgress() {
        hideLockScreen();
        progressButtonView.preventDefault();
    }

    @Override
    public void showSuccess() {
        hideLockScreen();
        startActivity(new Intent(this, SplashScreen.class));
        finish();
    }

    @Override
    public void showAuthError() {
        Snackbar.make(progressButtonView, R.string.error_auth, BaseTransientBottomBar.LENGTH_LONG)
                .show();
    }
}
