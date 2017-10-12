package ru.mobilesoft.piligram.ui.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.model.Vacation;
import ru.mobilesoft.piligram.model.response.People;
import ru.mobilesoft.piligram.utils.DateUtils;
import ru.mobilesoft.piligram.utils.ImageUtils;
import su.ias.components.adapters.BaseListAdapter;
import su.ias.components.adapters.OnItemClickListener;

/**
 * Created on 9/28/17.
 */

public class PeopleAdapter extends BaseListAdapter<People, PeopleAdapter.ViewHolder> {

    public PeopleAdapter(@Nullable List<People> list, @Nullable OnItemListener listener) {
        super(list, listener);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflate(R.layout.item_view_people, parent));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        People item = getItem(position);
        String name = item.getName();
        if (item.getBirthday() != null) {
            name += holder.getContext()
                    .getString(R.string.people_years,
                               DateUtils.getDiffYears(item.getBirthday(), new Date()));
        }
        holder.name.setText(name);
        if (!TextUtils.isEmpty(item.getAvatarUrl())) {
            ImageUtils.loadImage(holder.getContext(), item.getAvatarUrl(), holder.avatar);
        } else {
            //TODO нужны лефолтные картинки
        }

        if (item.getVacations() != null && !item.getVacations().isEmpty()) {

            Vacation vacation = item.getVacations().get(item.getVacations().size() - 1);

            //@formatter:off
            holder.vacationDate.setText(
                    holder.getContext()
                            .getString(R.string.people_travel_date,
                                       DateUtils.convertDate("dd MMMM", vacation.getBeginDate()),
                                       DateUtils.convertDate("dd MMMM yyyy", vacation.getEndDate())));
            //@formatter:on
            holder.place.setText(holder.getContext()
                                         .getString(R.string.people_place_where,
                                                    vacation.getDirection()));

        } else {
            //TODO убрать magic string
            holder.place.setText("Куда: Хоть куда!");
            holder.vacationDate.setText("Могу поехать: \nнеизвестно");
        }

    }

    public interface OnItemListener extends OnItemClickListener {
        void sendMessageToPerson(int position);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_name)
        TextView name;

        @BindView(R.id.iv_avatar)
        ImageView avatar;

        @BindView(R.id.tv_date_vacation)
        TextView vacationDate;

        @BindView(R.id.tv_place_to_go)
        TextView place;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onItemClick(getLayoutPosition());
                }
            });
        }

        Context getContext() {
            return itemView.getContext();
        }

        @OnClick(R.id.btn_send_message)
        void sendMessage() {
            if (listener != null && listener instanceof OnItemListener) {
                ((OnItemListener) listener).sendMessageToPerson(getItemCount());
            }
        }
    }
}
