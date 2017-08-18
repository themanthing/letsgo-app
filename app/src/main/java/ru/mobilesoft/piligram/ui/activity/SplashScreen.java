package ru.mobilesoft.piligram.ui.activity;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.OnClick;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.mvp.presenter.SplashPresenter;
import ru.mobilesoft.piligram.mvp.view.SplashView;
import timber.log.Timber;

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

    @BindView(R.id.welcome_layout)
    ViewGroup welcomeLayout;

    @Override
    protected int getLayout() {
        return R.layout.activity_splash;
    }

    @OnClick(R.id.btn_enter)
    void onEnterButtonClick() {
        presenter.loginButtonClick();
    }

    @OnClick(R.id.btn_create_account)
    void onCreateAccountClick() {
        presenter.startCreateAccount();
    }

    @OnClick(R.id.btn_fb_auth)
    void onFbAuthClick() {

    }

    @OnClick(R.id.btn_vk_auth)
    void onVkAuthClick() {

    }

    @Override
    public void showRegistrationView() {
        startActivity(new Intent(this, RegistrationWizard.class));
    }

    @Override
    public void showLoginForm() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Override
    public void showButtons() {
        new Handler().postDelayed(() -> {
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.custom_slide_in_bottom);
            animation.setDuration(500);
            buttonsLayout.setVisibility(View.VISIBLE);
            buttonsLayout.startAnimation(animation);

            animation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
            animation.setDuration(500);
            btnEnter.setVisibility(View.VISIBLE);
            btnEnter.startAnimation(animation);

            welcomeLayout.animate().translationY(-220).setDuration(500).start();

        }, 2000);

    }

    @Override
    public void showWelcome() {
        Timber.d("успешно прошли авторизацию идем к приветствию");
        startActivity(new Intent(this, WelcomeActivity.class));
    }
}
