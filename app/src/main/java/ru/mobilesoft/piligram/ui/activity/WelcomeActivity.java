package ru.mobilesoft.piligram.ui.activity;

import ru.mobilesoft.piligram.R;

/**
 * Created on 8/18/17.
 * показывает приветствие и переходит на главный экран
 * при ошибке переход обратно и очистка токенов
 */

public class WelcomeActivity extends BaseActivity {



    @Override
    protected int getLayout() {
        return R.layout.activity_welcome;
    }
}
