package ru.mobilesoft.piligram.ui.fragments.registration;

import android.content.Intent;

import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.OnClick;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.mvp.presenter.FinishRegPresenter;
import ru.mobilesoft.piligram.mvp.view.FinishRegView;
import ru.mobilesoft.piligram.ui.activity.MainActivity;
import ru.mobilesoft.piligram.ui.activity.TravelWizard;
import ru.mobilesoft.piligram.ui.fragments.BaseFragment;

/**
 * Created on 8/16/17.
 * у нас все хорошо, продолжаем работу
 */

public class FinishRegistrationFragment extends BaseFragment implements FinishRegView {

    @InjectPresenter
    FinishRegPresenter presenter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_reg_finish;
    }

    @OnClick(R.id.btn_continue)
    void onContinueClick(){
        presenter.addVacation();
    }

    @OnClick(R.id.btn_skip)
    void onSkipClick(){
        presenter.skip();
    }

    @Override
    public void showMainScreen() {
        getActivity().startActivity(new Intent(getActivity(), MainActivity.class));
        getActivity().finish();
    }

    @Override
    public void showAddVacationWizard() {
        getActivity().startActivity(new Intent(getActivity(), TravelWizard.class));
        getActivity().finish();
    }
}
