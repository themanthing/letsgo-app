package ru.mobilesoft.piligram.ui.fragments.travels;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.ui.fragments.BaseWizardFragment;
import ru.mobilesoft.piligram.ui.widget.CustomRadioButton;

/**
 * Created on 10.09.17.
 */

public class TravelTypeFragment extends BaseWizardFragment {

    @BindView(R.id.select_group)
    ViewGroup selectGroup;

    private int selectedId = View.NO_ID;

    @Override
    protected int getLayout() {
        return R.layout.fragment_travel_type;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        for (int i = 0; i < selectGroup.getChildCount(); i++) {
            selectGroup.getChildAt(i).setOnClickListener(v -> {

                selectedId = v.getId();

                for (int k = 0; k < selectGroup.getChildCount(); k++) {
                    CustomRadioButton radioButton = (CustomRadioButton) selectGroup.getChildAt(k);
                    radioButton.setChecked(radioButton.getId() == selectedId);
                }

                setActionButtonEnabled(selectedId != View.NO_ID);

            });
        }
    }

    @Override
    protected void saveValue() {

    }

    @Override
    protected void loadValue() {

    }
}
