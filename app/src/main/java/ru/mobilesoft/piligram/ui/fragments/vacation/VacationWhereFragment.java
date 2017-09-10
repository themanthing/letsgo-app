package ru.mobilesoft.piligram.ui.fragments.vacation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import butterknife.BindView;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.ui.fragments.BaseWizardFragment;
import timber.log.Timber;

/**
 * Created on 9/7/17.
 */

public class VacationWhereFragment extends BaseWizardFragment {

    private static final String VACATION_DIRECTION = "direction";
    private static final String VACATION_DIRECTION_VAL = "direction_val";

    @BindView(R.id.sp_where)
    Spinner direction;

    @Override
    protected int getLayout() {
        return R.layout.fragment_vacation_where;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.vacation_direction, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        direction.setAdapter(adapter);
        setActionButtonText(R.string.done);
        setActionButtonEnabled(true);
    }

    @Override
    protected void saveValue() {
        Timber.d("direction  = " + direction.getSelectedItem());
        wizard.setValue(VACATION_DIRECTION, direction.getSelectedItemPosition());
        wizard.setValue(VACATION_DIRECTION_VAL, direction.getSelectedItem());
    }

    @Override
    protected void loadValue() {
        if (wizard.containsKey(VACATION_DIRECTION)){
            direction.setSelected((Boolean) wizard.getValue(VACATION_DIRECTION));
        }
    }
}
