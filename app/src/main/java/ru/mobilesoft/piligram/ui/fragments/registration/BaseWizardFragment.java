package ru.mobilesoft.piligram.ui.fragments.registration;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.ui.fragments.BaseFragment;

/**
 * Created on 8/14/17.
 */

public abstract class BaseWizardFragment extends BaseFragment {

    @BindView(R.id.toolbar)
    @Nullable
    Toolbar toolbar;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
