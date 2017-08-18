package ru.mobilesoft.piligram.ui.activity;

import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.mvp.presenter.RegistrationPresenter;
import ru.mobilesoft.piligram.mvp.view.RegistrationView;
import ru.mobilesoft.piligram.mvp.view.Wizard;
import ru.mobilesoft.piligram.ui.fragments.registration.EnterAvatarFragment;
import ru.mobilesoft.piligram.ui.fragments.registration.EnterBirthdayFragment;
import ru.mobilesoft.piligram.ui.fragments.registration.EnterEmailFragment;
import ru.mobilesoft.piligram.ui.fragments.registration.EnterNameFragment;
import ru.mobilesoft.piligram.ui.fragments.registration.EnterPasswordFragment;
import ru.mobilesoft.piligram.ui.fragments.registration.EnterSexFragment;
import ru.mobilesoft.piligram.ui.fragments.registration.FinishRegistrationFragment;
import ru.mobilesoft.piligram.ui.widget.TopProgressBar;
import su.ias.components.adapters.BaseFragmentPagerAdapter;
import su.ias.components.views.LockedViewPager;

/**
 * Created on 8/14/17.
 */

public class RegistrationWizard extends BaseActivity implements RegistrationView, Wizard {

    @InjectPresenter
    RegistrationPresenter presenter;

    @BindView(R.id.vp_wizard)
    LockedViewPager viewPager;

    @BindView(R.id.pv_top_progress)
    TopProgressBar progressBar;

    @Override
    protected int getLayout() {
        return R.layout.activity_registration;
    }

    @Override
    public void initViewPager() {

        BaseFragmentPagerAdapter adapter =
                new BaseFragmentPagerAdapter(getSupportFragmentManager());
        adapter.addItem(new EnterNameFragment());
        adapter.addItem(new EnterEmailFragment());
        adapter.addItem(new EnterPasswordFragment());
        adapter.addItem(new EnterBirthdayFragment());
        adapter.addItem(new EnterSexFragment());
        adapter.addItem(new EnterAvatarFragment());
        // покажем что все ок, после регистарции
        adapter.addItem(new FinishRegistrationFragment());
        viewPager.setAdapter(adapter);
        viewPager.setSwipeDisabled(true);
        progressBar.setupFromViewPager(viewPager);
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
    public void showNextStep() {
        if (viewPager.getAdapter().getCount() != viewPager.getCurrentItem() -1 ) {
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
        }else{
            // все данные подготовленны пора на сервер отправлять
            presenter.register();
        }
    }

    @Override
    public void showSuccessScreen() {
        viewPager.setCurrentItem(viewPager.getAdapter().getCount(), true);
    }

    @Override
    public void setValue(String key, Object value) {
        presenter.setValue(key, value);
    }

    @Override
    public Object getValue(String key) {
        return presenter.getValue(key);
    }

    @Override
    public boolean containsKey(String name) {
        return presenter.containsKey(name);
    }
}
