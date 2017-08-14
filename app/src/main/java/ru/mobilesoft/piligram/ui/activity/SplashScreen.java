package ru.mobilesoft.piligram.ui.activity;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.OnClick;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.mvp.presenter.SplashPresenter;
import ru.mobilesoft.piligram.mvp.view.SplashView;

/**
 * Created on 8/7/17.
 */

public class SplashScreen extends BaseActivity implements SplashView {

    @InjectPresenter
    SplashPresenter presenter;

    @BindView(R.id.buttons)
    ViewGroup buttonsLayout;

    @BindView(R.id.btn_enter)
    View btnEnter;

    @Override
    protected int getLayout() {
        return R.layout.activity_splash;
    }

    @OnClick(R.id.btn_enter)
    void onEnterButtonClick(){
        presenter.loginButtonClick();
    }

    @OnClick(R.id.btn_create_account)
    void onCreateAccountClick(){
        presenter.startCreateAccount();
    }

    @OnClick(R.id.btn_fb_auth)
    void onFbAuthClick(){

    }

    @OnClick(R.id.btn_vk_auth)
    void onVkAuthClick(){

    }

    @Override
    public void showRegistrationView() {
        startActivity(new Intent(this, RegistrationWizard.class));
    }

    @Override
    public void showLoginForm() {
        startActivity(new Intent(this, LoginActivity.class));
    }
}
