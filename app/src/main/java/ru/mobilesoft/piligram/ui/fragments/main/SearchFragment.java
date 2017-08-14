package ru.mobilesoft.piligram.ui.fragments.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.arellomobile.mvp.presenter.InjectPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.events.MessageEvent;
import ru.mobilesoft.piligram.mvp.presenter.SearchMainScreenPresenter;
import ru.mobilesoft.piligram.mvp.view.SearchMainScreenView;
import ru.mobilesoft.piligram.ui.adapters.SearchScreenPagerAdapter;
import ru.mobilesoft.piligram.ui.fragments.BaseFragment;
import ru.mobilesoft.piligram.utils.Constants;
import timber.log.Timber;

/**
 * Created on 8/7/17.
 */

public class SearchFragment extends BaseFragment implements SearchMainScreenView {

    @BindView(R.id.pager)
    ViewPager mainPager;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    @InjectPresenter
    SearchMainScreenPresenter presenter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_search;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SearchScreenPagerAdapter pagerAdapter =
                new SearchScreenPagerAdapter(getChildFragmentManager());

        pagerAdapter.addItem(new MainFragment(), getString(R.string.all));
        pagerAdapter.addItem(new TravelsFragment(), getString(R.string.title_travels));
        pagerAdapter.addItem(new PeopleFragment(), getString(R.string.people));

        mainPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(mainPager);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    @SuppressWarnings("unused")
    public void onMessageEvent(MessageEvent event) {
        Timber.d("Пришло событие: " + event.getAction());
        if (Constants.ACTION_SHOW_PEOPLE_FORM.equals(event.getAction())) {
            presenter.showPeopleTab();
        } else if (Constants.ACTION_SHOW_TRAVELS_FORM.equals(event.getAction())) {
            presenter.showTravelsTab();
        }
    }

    @Override
    public void setCurrentTab(int i) {
        mainPager.setCurrentItem(i, true);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
