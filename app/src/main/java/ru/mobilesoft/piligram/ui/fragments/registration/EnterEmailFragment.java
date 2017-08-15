package ru.mobilesoft.piligram.ui.fragments.registration;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.utils.SimpleTextWatcher;
import ru.mobilesoft.piligram.utils.ValidateUtils;

/**
 * Created on 8/14/17.
 */

public class EnterEmailFragment extends BaseWizardFragment {

    private static final String KEY = "email";

    @BindView(R.id.ed_email)
    EditText edEmail;

    @Override
    protected int getLayout() {
        return R.layout.fragment_reg_email;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (actionButton != null){

            TextWatcher watcher = new SimpleTextWatcher(){
                @Override
                public void afterTextChanged(Editable editable) {
                    actionButton.setEnabled(editable.length() > 3);
                }
            };
            edEmail.addTextChangedListener(watcher);
        }
    }

    @Override
    protected boolean validate() {
        return ValidateUtils.validateEmail(edEmail.getText());
    }

    @Override
    protected void saveValue() {
        wizard.setValue(KEY, edEmail.getText().toString());
    }

    @Override
    protected void loadValue() {
        if (wizard.containsKey(KEY)){
            edEmail.setText(String.valueOf(wizard.getValue(KEY)));
        }
    }
}
