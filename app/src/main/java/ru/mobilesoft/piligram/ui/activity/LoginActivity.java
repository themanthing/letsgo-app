package ru.mobilesoft.piligram.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.OnClick;
import ru.mobilesoft.piligram.R;

/**
 * Created on 8/14/17.
 * Страница с вводом логина и пароля
 */

public class LoginActivity extends BaseActivity {

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

    }

    @OnClick(R.id.tv_remember_password)
    void onRememberPasswordClick(){

    }
}
