package ru.mobilesoft.piligram.ui.adapters;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.ButterKnife;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.model.Travel;
import su.ias.components.adapters.BaseListAdapter;
import su.ias.components.adapters.OnItemClickListener;

/**
 * Created on 9/28/17.
 */

public class TravelAdapter extends BaseListAdapter<Travel, TravelAdapter.ViewHolder> {

    public TravelAdapter(@Nullable List list, @Nullable OnItemClickListener listener) {
        super(list, listener);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflate(R.layout.item_view_travel, parent));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Travel travel = getItem(position);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
