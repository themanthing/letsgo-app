package ru.mobilesoft.piligram.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import ru.mobilesoft.piligram.R;

/**
 * Created on 8/8/17.
 * Базовый класс для списков
 */

public abstract class BaseListFragment extends BaseFragment {

    @BindView(R.id.rv_list)
    RecyclerView list;

    @BindView(R.id.page_title)
    TextView title;

    @Override
    protected int getLayout() {
        return R.layout.fragment_search_list;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        title.setVisibility(View.GONE);
        setLayoutManager();
        setAdapter();
    }

    protected void setLayoutManager(){
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    protected abstract void setAdapter();

    protected void setTitle(@StringRes int titleId){
        setTitle(getString(titleId));
    }

    protected void setTitle(CharSequence title){
        if (!TextUtils.isEmpty(title)){
            this.title.setText(title);
            this.title.setVisibility(View.VISIBLE);
        }else{
            this.title.setVisibility(View.GONE);
        }
    }
}
