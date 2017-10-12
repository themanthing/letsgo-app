package ru.mobilesoft.piligram.ui.fragments.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.view.View;

import ru.mobilesoft.piligram.ui.adapters.PeopleAdapter;
import ru.mobilesoft.piligram.ui.fragments.BaseListFragment;

/**
 * Created on 8/8/17.
 * Люди спиок
 */

public class PeopleFragment extends BaseListFragment {


    private PeopleAdapter peopleAdapter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setTitle(null);
    }

    @Override
    protected void setAdapter() {
        peopleAdapter = new PeopleAdapter(null, new PeopleAdapter.OnItemListener() {
            @Override
            public void sendMessageToPerson(int position) {

            }

            @Override
            public void onItemClick(int position) {

            }
        });
        list.setAdapter(peopleAdapter);
        DividerItemDecoration decoration =
                new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL);
        //decoration.setDrawable();
        list.addItemDecoration(decoration);

    }
}
