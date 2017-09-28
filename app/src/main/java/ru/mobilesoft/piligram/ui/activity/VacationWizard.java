package ru.mobilesoft.piligram.ui.activity;

import android.content.Intent;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import org.greenrobot.eventbus.EventBus;

import ru.mobilesoft.piligram.events.MessageEvent;
import ru.mobilesoft.piligram.mvp.presenter.VacationPresenter;
import ru.mobilesoft.piligram.mvp.view.VacationView;
import ru.mobilesoft.piligram.ui.fragments.vacation.VacationDateFragment;
import ru.mobilesoft.piligram.ui.fragments.vacation.VacationDaysFragment;
import ru.mobilesoft.piligram.ui.fragments.vacation.VacationWhereFragment;
import ru.mobilesoft.piligram.utils.Constants;
import su.ias.components.adapters.BaseFragmentPagerAdapter;
import timber.log.Timber;

import static ru.mobilesoft.piligram.utils.Constants.OPEN_AS_RESULT;

/**
 * Created on 8/16/17.
 * это тоже простой мастер по созданию отпуска...
 */

public class VacationWizard extends BaseWizardActivity implements VacationView {

    @InjectPresenter
    VacationPresenter presenter;

    @ProvidePresenter
    VacationPresenter provideVacationPresenter(){
        return new VacationPresenter(getIntent().getBooleanExtra(OPEN_AS_RESULT, false));
    }

    @Override
    public void showNextStep() {
        if (viewPager.getCurrentItem() + 1 < getAdapter().getCount()) {
            if (viewPager.getCurrentItem() == 0) {
                EventBus.getDefault().post(new MessageEvent(Constants.EVENT_UPDATE_DATE));
            }
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
        } else {
            Timber.d("заполнили все данные по отпуску");
            presenter.sendVacationData(wizardPresenter.getValues());
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

    @Override
    public void showMainScreen() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void returnSuccess() {
        setResult(RESULT_OK);
        finish();
    }
}
