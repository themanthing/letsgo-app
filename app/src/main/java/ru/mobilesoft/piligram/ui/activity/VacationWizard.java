package ru.mobilesoft.piligram.ui.activity;

import ru.mobilesoft.piligram.ui.fragments.registration.EnterPasswordFragment;
import ru.mobilesoft.piligram.ui.fragments.vacation.VacationDateFragment;
import ru.mobilesoft.piligram.ui.fragments.vacation.VacationDaysFragment;
import ru.mobilesoft.piligram.ui.fragments.vacation.VacationWhereFragment;
import su.ias.components.adapters.BaseFragmentPagerAdapter;
import timber.log.Timber;

/**
 * Created on 8/16/17.
 * это тоже простой мастер по созданию отпуска...
 */

public class VacationWizard extends BaseWizardActivity {

    @Override
    public void showNextStep() {
        if (viewPager.getCurrentItem() < getAdapter().getCount()) {
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
        }else{
            Timber.d("заполнили все данные по отпуску");
        }
    }

    @Override
    BaseFragmentPagerAdapter getAdapter() {
        BaseFragmentPagerAdapter adapter =
                new BaseFragmentPagerAdapter(getSupportFragmentManager());
        adapter.addItem(new VacationDateFragment());
        adapter.addItem(new VacationDaysFragment());
        adapter.addItem(new VacationWhereFragment());
        return adapter;
    }
}
