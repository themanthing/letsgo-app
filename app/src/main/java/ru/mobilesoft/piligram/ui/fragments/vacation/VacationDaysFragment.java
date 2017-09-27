package ru.mobilesoft.piligram.ui.fragments.vacation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Date;

import butterknife.BindView;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.events.MessageEvent;
import ru.mobilesoft.piligram.ui.fragments.BaseWizardFragment;
import ru.mobilesoft.piligram.utils.Constants;
import ru.mobilesoft.piligram.utils.DateUtils;
import ru.mobilesoft.piligram.utils.SimpleTextWatcher;

import static ru.mobilesoft.piligram.utils.Constants.VACATION_BEGIN_DATE;
import static ru.mobilesoft.piligram.utils.Constants.VACATION_DAYS_COUNT;
import static ru.mobilesoft.piligram.utils.Constants.VACATION_DAYS_TYPE;
import static ru.mobilesoft.piligram.utils.Constants.VACATION_DAYS_TYPE_VALUE;
import static ru.mobilesoft.piligram.utils.Constants.VACATION_END_DATE;

/**
 * Created on 9/7/17.
 */

public class VacationDaysFragment extends BaseWizardFragment {


    @BindView(R.id.sp_type)
    Spinner type;

    @BindView(R.id.daysCount)
    EditText edDaysCount;

    @Override
    protected int getLayout() {
        return R.layout.fragment_vacation_days;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EventBus.getDefault().register(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.vacation_dates_select, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type.setAdapter(adapter);
        edDaysCount.addTextChangedListener(new SimpleTextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
                setActionButtonEnabled(!TextUtils.isEmpty(editable));
            }
        });

        edDaysCount.setOnFocusChangeListener((daysCount, b) -> {
            int count = getDaysCount();
            if (b) {
                if (count > 0) {
                    edDaysCount.setText(String.valueOf(count));
                }else {
                    edDaysCount.setText("");
                }
            } else {
                edDaysCount.setText(getString(R.string.vacation_days_count, count));
            }
        });
    }

    private int getDaysCount() {
        String text = edDaysCount.getText().toString();
        if (TextUtils.isEmpty(text))
            return -1;
        return Integer.parseInt(text.replaceAll("[\\D]", ""));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    @SuppressWarnings("unused")
    void onMessage(MessageEvent messageEvent) {
        if (messageEvent.getAction().equals(Constants.EVENT_UPDATE_DATE)) {
            Date beginDate = (Date) wizard.getValue(VACATION_BEGIN_DATE);
            Date endDate = (Date) wizard.getValue(VACATION_END_DATE);
            if (beginDate != null && endDate != null) {
                edDaysCount.setText(getString(R.string.vacation_days_count,
                        DateUtils.getDateDiffInMilliseconds(beginDate, endDate)));
            }
        }
    }

    @Override
    protected void saveValue() {
        wizard.setValue(VACATION_DAYS_COUNT, getDaysCount());
        wizard.setValue(VACATION_DAYS_TYPE, type.getSelectedItemPosition());
        wizard.setValue(VACATION_DAYS_TYPE_VALUE, type.getSelectedItem());
    }

    @Override
    protected void loadValue() {
        if (wizard.containsKey(VACATION_DAYS_COUNT)) {
            int daysCount = (int) wizard.getValue(VACATION_DAYS_COUNT);
            edDaysCount.setText(getString(R.string.vacation_days_count, daysCount));
            type.setSelection((Integer) wizard.getValue(VACATION_DAYS_TYPE));
        }
    }
}
