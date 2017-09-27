package ru.mobilesoft.piligram.ui.fragments.registration;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.ui.fragments.BaseWizardFragment;
import ru.mobilesoft.piligram.utils.SimpleTextWatcher;
import su.ias.utils.ValidateUtils;

/**
 * Created on 8/14/17.
 * TODO проверить есть ли такой e-mail на сервере! если есть ошибку выдать!
 */

public class EnterEmailFragment extends BaseWizardFragment {

    private static final String KEY = "email";

    @BindView(R.id.ed_email)
    EditText edEmail;

    @BindView(R.id.ti_email)
    TextInputLayout emailLayout;

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
                    emailLayout.setErrorEnabled(false);
                }
            };
            edEmail.addTextChangedListener(watcher);
        }
    }

    @Override
    protected boolean validate() {
        boolean valid = ValidateUtils.validateEmail(edEmail.getText());
        if (!valid){
            emailLayout.setError(getString(R.string.error_incorrect_email));
            emailLayout.setErrorEnabled(true);
        }
        return valid;
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
