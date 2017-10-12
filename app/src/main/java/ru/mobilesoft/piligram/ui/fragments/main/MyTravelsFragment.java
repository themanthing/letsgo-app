package ru.mobilesoft.piligram.ui.fragments.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import butterknife.BindView;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.ui.fragments.BaseFragment;
import ru.mobilesoft.piligram.ui.fragments.travels.OwnTravelsFragment;
import ru.mobilesoft.piligram.ui.fragments.travels.ParticipateTravelsListFragment;
import su.ias.components.adapters.BaseFragmentPagerAdapter;

/**
 * Created on 8/8/17.
 */

public class MyTravelsFragment extends BaseFragment {

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    @BindView(R.id.travels)
    ViewPager pager;

    @Override
    protected int getLayout() {
        return R.layout.fragment_my_travel;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        BaseFragmentPagerAdapter adapter = new BaseFragmentPagerAdapter(getChildFragmentManager());
        adapter.addItem(new OwnTravelsFragment(), getString(R.string.own_travel));
        adapter.addItem(new ParticipateTravelsListFragment(), getString(R.string.participate_travel));
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);

    }

}
