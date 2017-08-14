package ru.mobilesoft.piligram.ui.fragments.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.ui.fragments.BaseListFragment;

/**
 * Created on 8/8/17.
 */

public class MyMessagesFragment extends BaseListFragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setTitle(R.string.title_messages);
    }

    @Override
    protected void setAdapter() {

    }
}
