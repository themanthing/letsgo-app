package ru.mobilesoft.piligram.ui.fragments.registration;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.mvp.view.Wizard;
import ru.mobilesoft.piligram.ui.fragments.BaseFragment;

/**
 * Created on 8/14/17.
 */

public abstract class BaseWizardFragment extends BaseFragment {

    @BindView(R.id.toolbar)
    @Nullable
    Toolbar toolbar;

    @BindView(R.id.btn_action)
    @Nullable
    Button actionButton;

    Wizard wizard;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        wizard = (Wizard) getActivity();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (toolbar != null) {
            toolbar.setNavigationOnClickListener(v -> getActivity().onBackPressed());
        }
        loadValue();

        if (actionButton != null) {
            actionButton.setEnabled(false);
            actionButton.setText(R.string.next);
            actionButton.setOnClickListener(v -> {
                if (validate()){
                    saveValue();
                    wizard.showNextStep();
                }
            });
        }
    }

    protected boolean validate(){
       return actionButton.isEnabled();
    }

    protected abstract void saveValue();

    protected abstract void loadValue();

    protected void setActionButtonEnabled(boolean enabled){
        if (actionButton != null){
            actionButton.setEnabled(enabled);
        }
    }

    @Override
    public void onDetach() {
        wizard = null;
        super.onDetach();
    }
}
