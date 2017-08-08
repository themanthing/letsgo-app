package ru.mobilesoft.piligram.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import butterknife.BindView;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.ui.adapters.SearchScreenPagerAdapter;

/**
 * Created on 8/7/17.
 */

public class SearchFragment extends BaseFragment {

    @BindView(R.id.pager)
    ViewPager mainPager;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

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

}
