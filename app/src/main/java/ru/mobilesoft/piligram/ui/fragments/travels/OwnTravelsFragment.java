package ru.mobilesoft.piligram.ui.fragments.travels;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.OnClick;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.ui.activity.TravelWizard;
import ru.mobilesoft.piligram.ui.fragments.BaseFragment;
import ru.mobilesoft.piligram.utils.Constants;

/**
 * Created on 10/12/17.
 */

public class OwnTravelsFragment extends BaseFragment {

    @BindView(R.id.empty)
    ViewGroup emptyView;

    @BindView(R.id.travels)
    RecyclerView recyclerView;

    @Override
    protected int getLayout() {
        return R.layout.fragment_own_travel;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @OnClick(R.id.btn_add_travel)
    void onAddTravelClick(){
        getActivity().startActivityForResult(new Intent(getActivity(), TravelWizard.class),
                                             Constants.RESULT_TRAVEL_WIZARD);
    }
}
