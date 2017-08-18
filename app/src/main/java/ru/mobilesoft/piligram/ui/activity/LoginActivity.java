package ru.mobilesoft.piligram.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.OnClick;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.mvp.presenter.LoginPresenter;
import ru.mobilesoft.piligram.mvp.view.LoginView;

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

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
    }

    @OnClick(R.id.btn_action)
    void onEnterButtonClick(){
        presenter.login(email.getText().toString(),
                        password.getText().toString());

    }

    @OnClick(R.id.tv_remember_password)
    void onRememberPasswordClick(){

    }

    @Override
    public void showEmailValidationError() {

    }

    @Override
    public void showPasswordError() {

    }
}
