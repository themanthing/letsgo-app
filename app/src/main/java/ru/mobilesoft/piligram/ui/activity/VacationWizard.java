package ru.mobilesoft.piligram.ui.activity;

import android.support.annotation.Nullable;

import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.mvp.view.Wizard;

/**
 * Created on 8/16/17.
 * это тоже простой мастер по созданию отпуска...
 */

public class VacationWizard extends BaseActivity implements Wizard {
    @Override
    public void showNextStep() {

    }

    @Override
    public void setValue(String key, Object value) {

    }

    @Nullable
    @Override
    public Object getValue(String key) {
        return null;
    }

    @Override
    public boolean containsKey(String name) {
        return false;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_wizard;
    }
}
