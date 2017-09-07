package ru.mobilesoft.piligram.ui.fragments.registration;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RadioGroup;

import butterknife.BindView;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.ui.fragments.BaseWizardFragment;

/**
 * Created on 8/14/17.
 */

public class EnterSexFragment extends BaseWizardFragment {

    private static String KEY_SEX = "sex";

    @BindView(R.id.radio_group)
    RadioGroup radioGroup;

    @Override
    protected int getLayout() {
        return R.layout.fragment_reg_sex;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            setActionButtonEnabled(true);
        });
    }

    @Override
    protected void saveValue() {
        if (radioGroup.getCheckedRadioButtonId() == R.id.female){
            wizard.setValue(KEY_SEX, "female");
        }else{
            wizard.setValue(KEY_SEX, "male");
        }
    }

    @Override
    protected void loadValue() {
        if (wizard.containsKey(KEY_SEX)){
            String val = String.valueOf(wizard.getValue(KEY_SEX));
            if ("female".equals(val)){
                radioGroup.check(R.id.female);
            }else{
                radioGroup.check(R.id.male);
            }
            setActionButtonEnabled(true);
        }
    }
}
