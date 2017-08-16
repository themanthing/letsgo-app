package ru.mobilesoft.piligram.ui.fragments.registration;

import butterknife.OnClick;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.ui.fragments.BaseFragment;

/**
 * Created on 8/16/17.
 * у нас все хорошо, продолжаем работу
 */

public class FinishRegistrationFragment extends BaseFragment {

    @Override
    protected int getLayout() {
        return R.layout.fragment_reg_finish;
    }

    @OnClick(R.id.btn_continue)
    void onContinueClick(){

    }

    @OnClick(R.id.btn_skip)
    void onSkipClick(){

    }

}
