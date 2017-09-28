package ru.mobilesoft.piligram.ui.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.model.Vacation;
import ru.mobilesoft.piligram.utils.DateUtils;
import su.ias.components.adapters.BaseListAdapter;
import su.ias.components.adapters.OnItemClickListener;
import su.ias.utils.GrammarUtils;

/**
 * Created on 9/27/17.
 */

public class MyProfileVacationAdapter extends BaseListAdapter<Vacation, RecyclerView.ViewHolder> {

    private static final int HEADER = 1;
    private static final int FOOTER = 2;
    private View.OnClickListener addListener;

    public MyProfileVacationAdapter(@Nullable List<Vacation> list,
                                    @Nullable OnItemClickListener listener,
                                    @Nullable View.OnClickListener addListener) {
        super(list, listener);
        this.addListener = addListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case HEADER:
                return new HeaderViewHolder(inflate(R.layout.header_profile, parent));
            case FOOTER:
                return new FooterViewHolder(inflate(R.layout.footer_profile, parent));
            default:
                return new VacationViewHolder(inflate(R.layout.item_profile_vacation, parent));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (getItemViewType(position) == 0) {
            VacationViewHolder vHolder = (VacationViewHolder) holder;
            Vacation item = getItem(position-1);
            Context context = vHolder.itemView.getContext();
            //@formatter:off
            vHolder.dayCount.setText(
                    context.getString(R.string.from,
                                      item.getType(),
                                      GrammarUtils.getDayCaseByNumber(
                                              context, item.getDaysCount())));
            //@formatter:on

            vHolder.place.setText(item.getDirection());
            //@formatter:off
            vHolder.date.setText(
                    context.getString(R.string.item_profile_days,
                                      DateUtils.convertDateToMonthAndYear(item.getBeginDate()),
                                      DateUtils.convertDateToMonthAndYear(item.getEndDate())));
            //@formatter:on
        }
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0) {
            return HEADER;
        }

        if (position == getItemCount() - 1) {
            return FOOTER;
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return super.getItemCount() + 2;
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }

    class VacationViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_day_count)
        TextView dayCount;

        @BindView(R.id.tv_place)
        TextView place;

        @BindView(R.id.tv_date)
        TextView date;

        VacationViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onItemClick(getLayoutPosition());
                }
            });
        }
    }

    class FooterViewHolder extends RecyclerView.ViewHolder {
        FooterViewHolder(View itemView) {
            super(itemView);
            itemView.findViewById(R.id.btn_add_vacation).setOnClickListener(addListener);
        }
    }
}
