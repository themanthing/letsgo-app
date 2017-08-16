package ru.mobilesoft.piligram.ui.fragments.registration;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import ru.mobilesoft.piligram.R;

/**
 * Created on 8/14/17.
 */

public class EnterPasswordFragment extends BaseWizardFragment {

    private static final String KEY_PASS = "password";

    @BindView(R.id.ed_password)
    EditText edPassword;

    @Override
    protected int getLayout() {
        return R.layout.fragment_reg_password;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected boolean validate() {
        return !TextUtils.isEmpty(edPassword.getText()) && edPassword.getText().length() > 5;
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
