package ru.mobilesoft.piligram.ui.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.model.Travel;
import ru.mobilesoft.piligram.utils.DateUtils;
import ru.mobilesoft.piligram.utils.ImageUtils;
import su.ias.components.adapters.BaseListAdapter;
import su.ias.components.adapters.OnItemClickListener;

/**
 * Created on 9/28/17.
 */

public class TravelAdapter extends BaseListAdapter<Travel, TravelAdapter.ViewHolder> {

    private final int orientation;

    public TravelAdapter(@Nullable List<Travel> list,
                         @Nullable TravelAdapterListener listener,
                         int orientation) {
        super(list, listener);
        this.orientation = orientation;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflate(R.layout.item_view_travel, parent));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Travel travel = getItem(position);

        holder.tvTravelName.setText(travel.getTitle());
        holder.tvTravelDate.setText(DateUtils.getTravelDates(travel.getBeginDate(),
                                                             travel.getEndDate()));

        holder.tvTravelInfo.setText(String.valueOf(travel.getPrice()));

        if (!TextUtils.isEmpty(travel.getImage())){
            ImageUtils.loadImage(holder.getContext(), travel.getImage(), holder.ivTravel);
        }else{
            // need placeholder!
        }

    }

    public interface TravelAdapterListener extends OnItemClickListener {
        void onFavoriteClick(int position);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_travel)
        ImageView ivTravel;

        @BindView(R.id.tv_travel_date)
        TextView tvTravelDate;

        @BindView(R.id.btn_favorite)
        ImageView btnFavorite;

        @BindView(R.id.tv_travel_name)
        TextView tvTravelName;

        @BindView(R.id.people_layout)
        LinearLayout peopleLayout;

        @BindView(R.id.travel_info)
        TextView tvTravelInfo;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onItemClick(getLayoutPosition());
                }
            });
        }

        @OnClick(R.id.btn_favorite)
        void onFavoriteClick() {
            if (listener != null) {
                ((TravelAdapterListener) listener).onFavoriteClick(getLayoutPosition());
            }
        }

        Context getContext(){
            return itemView.getContext();
        }

    }

}
