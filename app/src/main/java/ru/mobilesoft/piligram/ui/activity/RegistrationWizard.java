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

public class RegistrationWizard extends BaseWizardActivity implements RegistrationView {

    @InjectPresenter
    RegistrationPresenter presenter;

    @Override
    BaseFragmentPagerAdapter getAdapter() {
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
        return adapter;
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
}
