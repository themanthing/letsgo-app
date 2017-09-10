package ru.mobilesoft.piligram.ui.fragments.vacation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.ui.dialogs.DialogFactory;
import ru.mobilesoft.piligram.ui.fragments.BaseWizardFragment;
import ru.mobilesoft.piligram.utils.DateUtils;
import timber.log.Timber;

/**
 * Created on 9/7/17.
 */

public class VacationDateFragment extends BaseWizardFragment {

    static final String VACATION_BEGIN_DATE = "v_begin_date";
    static final String VACATION_END_DATE = "v_end_date";

    private Date beginDate;
    private Date endDate;

    @BindView(R.id.ed_date)
    EditText edBeginDate;

    @BindView(R.id.ed_date_end)
    EditText edEndDate;

    @Override
    protected int getLayout() {
        return R.layout.fragment_vacation_date_select;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @OnClick(R.id.ti_date_layout)
    void beginDateClick() {
        DialogFactory.createDatePicker(getActivity(), (view, year, month, dayOfMonth) -> {
            beginDate = DateUtils.createDate(year, month, dayOfMonth);
            Timber.d("begin date = " + beginDate);
            edBeginDate.setText(DateUtils.convertDateToString(beginDate));
            checkButtonStatus();
        }, new Date(), endDate).show();
    }

    @OnClick(R.id.ti_date_end_layout)
    void endDateClick() {
        DialogFactory.createDatePicker(getActivity(), (view, year, month, dayOfMonth) -> {
            endDate = DateUtils.createDate(year, month, dayOfMonth);
            Timber.d("end date = " + endDate);
            edEndDate.setText(DateUtils.convertDateToString(endDate));
            checkButtonStatus();
        }, beginDate, null).show();
    }

    private void checkButtonStatus() {
        setActionButtonEnabled(beginDate != null && endDate != null);
    }

    @Override
    public void onResume() {
        super.onResume();
        checkButtonStatus();
    }

    @Override
    protected void saveValue() {
        wizard.setValue(VACATION_BEGIN_DATE, beginDate);
        wizard.setValue(VACATION_END_DATE, endDate);
    }

    @Override
    protected void loadValue() {
        if (wizard.containsKey(VACATION_BEGIN_DATE)) {
            beginDate = (Date) wizard.getValue(VACATION_BEGIN_DATE);
            Timber.d("begin date = " + beginDate);
            edBeginDate.setText(DateUtils.convertDateToString(beginDate));

            endDate = (Date) wizard.getValue(VACATION_END_DATE);
            Timber.d("end date = " + endDate);
            edEndDate.setText(DateUtils.convertDateToString(endDate));
        }
    }
}
