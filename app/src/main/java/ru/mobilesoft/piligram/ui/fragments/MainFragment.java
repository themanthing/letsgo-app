package ru.mobilesoft.piligram.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import butterknife.OnClick;
import ru.mobilesoft.piligram.R;

/**
 * Created on 8/8/17.
 */

public class MainFragment extends BaseFragment {

    @Override
    protected int getLayout() {
        return R.layout.fragment_search_all;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @OnClick(R.id.travels)
    void onTravelsClick(){

    }

    @OnClick(R.id.people)
    void onPeopleClick(){

    }

}
