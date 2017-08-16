package ru.mobilesoft.piligram.ui.fragments.registration;

import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.ui.dialogs.DialogFactory;
import ru.mobilesoft.piligram.utils.DateUtils;
import timber.log.Timber;

/**
 * Created on 8/14/17.
 */

public class EnterBirthdayFragment extends BaseWizardFragment {

    private static final String KEY_BD = "birthday";
    @BindView(R.id.ed_date)
    TextView edDate;
    private Date date;

    @Override
    protected int getLayout() {
        return R.layout.fragment_reg_birthday;
    }

    @OnClick(R.id.ti_date_layout)
    void onBirthDayClick() {
        Calendar instance = Calendar.getInstance();
        Date maxDate = instance.getTime();
        instance.add(Calendar.YEAR, -90); // ну я надеюсь конечно но)
        Date minDate = instance.getTime();
        DialogFactory.createDatePicker(getActivity(), (view, year, month, dayOfMonth) -> {
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month, dayOfMonth, 0, 0, 0);
            setDate(calendar.getTime());
        }, minDate, maxDate).show();
    }

    private void setDate(Date date) {
        Timber.d("selected date = " + date);
        this.date = date;
        edDate.setText(DateUtils.convertDateToString(date));
        if (actionButton != null) {
            actionButton.setEnabled(true);
        }
    }

    @Override
    protected void saveValue() {
        if (date != null) {
            wizard.setValue(KEY_BD, date);
        }
    }

    @Override
    protected void loadValue() {
        if (wizard.containsKey(KEY_BD)) {
            setDate((Date) wizard.getValue(KEY_BD));
        }
    }
}
