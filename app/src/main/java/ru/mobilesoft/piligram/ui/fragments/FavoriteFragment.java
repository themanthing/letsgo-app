package ru.mobilesoft.piligram.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import ru.mobilesoft.piligram.R;

/**
 * Created on 8/8/17.
 * Закладки/Избранное
 */

public class FavoriteFragment extends BaseListFragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setTitle(R.string.title_favorites);
    }

    @Override
    protected void setAdapter() {

    }
}
