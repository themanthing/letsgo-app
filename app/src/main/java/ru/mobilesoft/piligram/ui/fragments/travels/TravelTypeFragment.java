package ru.mobilesoft.piligram.ui.fragments.travels;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.ui.fragments.BaseWizardFragment;
import ru.mobilesoft.piligram.ui.widget.CustomRadioButton;

import static ru.mobilesoft.piligram.utils.Constants.TRAVEL_TYPE;
import static ru.mobilesoft.piligram.utils.Constants.TRAVEL_TYPE_VALUE;

/**
 * Created on 10.09.17.
 */

public class TravelTypeFragment extends BaseWizardFragment {

    @BindView(R.id.select_group)
    ViewGroup selectGroup;

    private int selectedId = View.NO_ID;
    private String val;

    @Override
    protected int getLayout() {
        return R.layout.fragment_travel_type;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        for (int i = 0; i < selectGroup.getChildCount(); i++) {
            selectGroup.getChildAt(i).setOnClickListener(v -> {
                setItemSelected(v.getId());
                setActionButtonEnabled(selectedId != View.NO_ID);
            });
        }
    }

    private void setItemSelected(@IdRes int itemId){
        selectedId = itemId;
        for (int k = 0; k < selectGroup.getChildCount(); k++) {
            CustomRadioButton radioButton = (CustomRadioButton) selectGroup.getChildAt(k);

            if (radioButton.getId() == itemId){
                val = radioButton.getTitle();
                radioButton.setChecked(true);
            }else{
                radioButton.setChecked(false);
            }
        }
    }

    @Override
    protected void saveValue() {
        wizard.setValue(TRAVEL_TYPE, selectedId);
        wizard.setValue(TRAVEL_TYPE_VALUE, val);
    }

    @Override
    protected void loadValue() {
        if (wizard.containsKey(TRAVEL_TYPE)){
            setItemSelected(wizard.getInt(TRAVEL_TYPE));
        }
    }
}
