package ru.mobilesoft.piligram.ui.activity;

import org.greenrobot.eventbus.EventBus;

import ru.mobilesoft.piligram.events.MessageEvent;
import ru.mobilesoft.piligram.ui.fragments.travels.TravelCostFragment;
import ru.mobilesoft.piligram.ui.fragments.travels.TravelDateFragment;
import ru.mobilesoft.piligram.ui.fragments.travels.TravelFinishSragment;
import ru.mobilesoft.piligram.ui.fragments.travels.TravelImagesFragment;
import ru.mobilesoft.piligram.ui.fragments.travels.TravelRoadFragment;
import ru.mobilesoft.piligram.ui.fragments.travels.TravelTypeFragment;
import ru.mobilesoft.piligram.ui.fragments.vacation.VacationDateFragment;
import ru.mobilesoft.piligram.ui.fragments.vacation.VacationDaysFragment;
import ru.mobilesoft.piligram.ui.fragments.vacation.VacationWhereFragment;
import ru.mobilesoft.piligram.utils.Constants;
import su.ias.components.adapters.BaseFragmentPagerAdapter;
import timber.log.Timber;

/**
 * Created on 8/18/17.
 * мастер создания путешествия
 */

public class TravelWizard extends BaseWizardActivity {

    @Override
    public void showNextStep() {
        if (viewPager.getCurrentItem() + 1 < getAdapter().getCount()) {
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
        } else {
            Timber.d("заполнили все данные по путешествию");
        }
    }

    @Override
    BaseFragmentPagerAdapter getAdapter() {
        BaseFragmentPagerAdapter adapter =
                new BaseFragmentPagerAdapter(getSupportFragmentManager());
        adapter.addItem(new TravelTypeFragment());
        adapter.addItem(new TravelCostFragment());
        adapter.addItem(new TravelRoadFragment());
        adapter.addItem(new TravelDateFragment());
        adapter.addItem(new TravelImagesFragment());
        adapter.addItem(new TravelFinishSragment());
        return adapter;
    }
}
