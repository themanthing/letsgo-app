package ru.mobilesoft.piligram.ui.activity;

import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.mvp.presenter.WizardPresenter;
import ru.mobilesoft.piligram.mvp.view.Wizard;
import ru.mobilesoft.piligram.ui.widget.TopProgressBar;
import su.ias.components.adapters.BaseFragmentPagerAdapter;
import su.ias.components.views.LockedViewPager;

/**
 * Created on 8/18/17.
 * базовый класс визардов)
 */

public abstract class BaseWizardActivity extends BaseActivity implements Wizard {

    @InjectPresenter
    WizardPresenter wizardPresenter;

    @BindView(R.id.vp_wizard)
    LockedViewPager viewPager;

    @BindView(R.id.pv_top_progress)
    TopProgressBar progressBar;

    @Override
    protected int getLayout() {
        return R.layout.activity_wizard;
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1, true);
        }
    }

    @Override
    public void initViewPager() {
        viewPager.setAdapter(getAdapter());
        viewPager.setSwipeDisabled(true);
        progressBar.setupFromViewPager(viewPager);
    }

    abstract BaseFragmentPagerAdapter getAdapter();

    @Override
    public void setValue(String key, Object value) {
        wizardPresenter.setValue(key, value);
    }

    @Override
    public Object getValue(String key) {
        return wizardPresenter.getValue(key);
    }

    @Override
    public boolean containsKey(String name) {
        return wizardPresenter.containsKey(name);
    }
}
