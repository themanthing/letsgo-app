package ru.mobilesoft.piligram.ui.fragments.registration;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.utils.SimpleTextWatcher;

/**
 * Created on 8/14/17.
 */

public class EnterNameFragment extends BaseWizardFragment {

    @BindView(R.id.ed_name)
    EditText edName;

    @BindView(R.id.ed_parent_name)
    EditText edParentName;

    @Override
    protected int getLayout() {
        return R.layout.fragment_reg_name;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (actionButton != null) {
            actionButton.setEnabled(false);
            TextWatcher watcher = new SimpleTextWatcher() {
                @Override
                public void afterTextChanged(Editable editable) {
                    if (TextUtils.isEmpty(edName.getText()) || TextUtils.isEmpty(edParentName.getText())) {
                        actionButton.setEnabled(false);
                    } else {
                        if (edName.getText().length() < 3 || edParentName.getText().length() < 3) {
                            actionButton.setEnabled(false);
                        } else {
                            actionButton.setEnabled(true);
                        }
                    }
                }
            };

            edName.addTextChangedListener(watcher);
            edParentName.addTextChangedListener(watcher);
        }
    }
}
