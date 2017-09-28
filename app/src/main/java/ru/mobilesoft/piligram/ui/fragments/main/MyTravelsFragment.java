package ru.mobilesoft.piligram.ui.fragments.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.View;

import butterknife.OnClick;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.ui.activity.TravelWizard;
import ru.mobilesoft.piligram.ui.fragments.BaseListFragment;
import ru.mobilesoft.piligram.utils.Constants;

/**
 * Created on 8/8/17.
 */

public class MyTravelsFragment extends BaseListFragment {

    @Override
    protected int getLayout() {
        return R.layout.fragment_my_travel;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setTitle(R.string.my_travels);
    }

    @Override
    protected void setAdapter() {

    }

    @OnClick(R.id.bnt_add_travel)
    void onAddTravelAction(){
        getActivity().startActivityForResult(new Intent(getActivity(), TravelWizard.class),
                                             Constants.RESULT_TRAVEL_WIZARD);
    }


}
