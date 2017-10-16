package ru.mobilesoft.piligram.ui.fragments.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import butterknife.BindView;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.model.Travel;
import ru.mobilesoft.piligram.mvp.presenter.travels.TravelListPresenter;
import ru.mobilesoft.piligram.mvp.view.TravelListView;
import ru.mobilesoft.piligram.ui.adapters.TravelAdapter;
import ru.mobilesoft.piligram.ui.fragments.BaseFragment;
import su.ias.utils.AnimUtils;

/**
 * Created on 8/8/17.
 */

public class TravelsFragment extends BaseFragment implements TravelListView {

    @InjectPresenter
    TravelListPresenter presenter;

    @BindView(R.id.rv_list)
    RecyclerView travelList;

    @BindView(R.id.empty)
    TextView emptyView;

    private TravelAdapter adapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_travel_list;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        travelList.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void showEmptyView(boolean animate) {
        if (animate){
            AnimUtils.crossfade(emptyView, travelList, 400);
        }else{
            emptyView.setVisibility(View.VISIBLE);
            travelList.setVisibility(View.GONE);
        }
    }

    @Override
    public void showList(boolean animate) {
        if (animate){
            AnimUtils.crossfade(travelList, emptyView, 400);
        }else{
            emptyView.setVisibility(View.GONE);
            travelList.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void createOrUpdateAdapter(List<Travel> data) {

        if (adapter == null){
            adapter = new TravelAdapter(data, new TravelAdapter.TravelAdapterListener() {
                @Override
                public void onFavoriteClick(int position) {

                }

                @Override
                public void onItemClick(int position) {

                }
            }, LinearLayoutManager.HORIZONTAL);
            travelList.setAdapter(adapter);
        }

    }
}
