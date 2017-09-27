package ru.mobilesoft.piligram.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import ru.mobilesoft.piligram.R;

/**
 * Created on 9/27/17.
 * редактирование профиля пользователя
 */

public class MyProfileEditActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected int getLayout() {
        return R.layout.activity_profile_edit;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar.setTitle("");
        toolbar.setNavigationOnClickListener(v -> finish());
    }
}
