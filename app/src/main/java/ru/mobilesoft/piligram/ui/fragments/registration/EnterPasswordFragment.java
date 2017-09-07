package ru.mobilesoft.piligram.ui.fragments.registration;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.ui.fragments.BaseWizardFragment;
import ru.mobilesoft.piligram.utils.SimpleTextWatcher;

/**
 * Created on 8/14/17.
 */

public class EnterPasswordFragment extends BaseWizardFragment {

    private static final String KEY_PASS = "password";

    @BindView(R.id.ed_password)
    EditText edPassword;

    @BindView(R.id.ti_password_layout)
    TextInputLayout passwordLayout;

    @Override
    protected int getLayout() {
        return R.layout.fragment_reg_password;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edPassword.addTextChangedListener(new SimpleTextWatcher(){
            @Override
            public void afterTextChanged(Editable editable) {
                passwordLayout.setErrorEnabled(false);
                if (actionButton != null) {
                    actionButton.setEnabled(editable.length() > 0);
                }
            }
        });
    }

    @Override
    protected boolean validate() {
        boolean valid = !TextUtils.isEmpty(edPassword.getText()) && edPassword.getText().length() > 5;

        if (edPassword.getText().length() <= 5){
            passwordLayout.setError(getString(R.string.error_password_length));
            passwordLayout.setErrorEnabled(true);
        }

        return valid;
    }

    @Override
    protected void saveValue() {
        wizard.setValue(KEY_PASS, edPassword.getText().toString());
    }

    @Override
    protected void loadValue() {
        if (wizard.containsKey(KEY_PASS)){
            edPassword.setText(String.valueOf(wizard.getValue(KEY_PASS)));
        }
    }
}
