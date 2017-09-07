package ru.mobilesoft.piligram.ui.fragments.vacation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import java.util.Date;

import butterknife.OnClick;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.ui.dialogs.DialogFactory;
import ru.mobilesoft.piligram.ui.fragments.BaseWizardFragment;

/**
 * Created on 9/7/17.
 */

public class VacationDateFragment extends BaseWizardFragment {

    private static final String VACAITION_BEGIN_DATE = "v_begin_date";
    private static final String VACAITION_END_DATE = "v_end_date";

    private Date beginDate;
    private Date endDate;

    @Override
    protected int getLayout() {
        return R.layout.fragment_vacation_date_select;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @OnClick(R.id.ti_date_layout)
    void beginDateClick(){
        DialogFactory.createDatePicker(getActivity(), (view, year, month, dayOfMonth) -> {

        }, new Date(), null).show();
    }

    @OnClick(R.id.ti_date_end_layout)
    void endDateClick(){
        DialogFactory.createDatePicker(getActivity(), (view, year, month, dayOfMonth) -> {

        }, new Date(), beginDate).show();
    }

    @Override
    protected void saveValue() {

    }

    @Override
    protected void loadValue() {

    }
}
