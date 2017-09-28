package ru.mobilesoft.piligram.ui.fragments.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.model.Vacation;
import ru.mobilesoft.piligram.mvp.presenter.ProfilePresenter;
import ru.mobilesoft.piligram.mvp.view.MyProfileView;
import ru.mobilesoft.piligram.ui.activity.MyProfileEditActivity;
import ru.mobilesoft.piligram.ui.activity.VacationWizard;
import ru.mobilesoft.piligram.ui.adapters.MyProfileVacationAdapter;
import ru.mobilesoft.piligram.ui.fragments.BaseFragment;
import ru.mobilesoft.piligram.utils.Constants;
import ru.mobilesoft.piligram.utils.ImageUtils;

import static ru.mobilesoft.piligram.utils.Constants.RESULT_TRAVEL_WIZARD;
import static ru.mobilesoft.piligram.utils.Constants.SEX_MALE;

/**
 * Created on 9/27/17.
 */

public class MyProfileFragment extends BaseFragment implements MyProfileView {

    @InjectPresenter
    ProfilePresenter presenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.my_vacations)
    RecyclerView vacations;

    @BindView(R.id.iv_avatar)
    ImageView avatar;

    MyProfileVacationAdapter adapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_my_profile;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        vacations.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void createVacationAdapter(List<Vacation> vacations) {

        List<Vacation> data = new ArrayList<>();
        data.addAll(vacations);
        Arrays.sort(data.toArray());

        if (adapter == null) {
            adapter = new MyProfileVacationAdapter(data, position -> {
                // TODO открыть окно информации по отпуску... хотя что там???
            }, v -> presenter.openAddVacationWizard());
            this.vacations.setAdapter(adapter);
        } else {
            adapter.clear();
            adapter.addAll(data);
        }
    }

    @Override
    public void showMyName(String name, String parentName) {
        String myName = name;
        if (!TextUtils.isEmpty(parentName)) {
            myName += " " + parentName;
        }
        toolbar.setTitle(myName);
    }

    @Override
    public void showDefaultAvatar(String sex) {
        // покажем дефеолтную авку
        if (SEX_MALE.equalsIgnoreCase(sex)){

        }else{

        }
    }

    @OnClick(R.id.btn_edit_profile)
    void onEditProfileClick(){
        presenter.editProfile();
    }

    @Override
    public void showAvatar(String avatarUrl) {
        ImageUtils.loadImage(getActivity(), avatarUrl, avatar);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RESULT_TRAVEL_WIZARD && resultCode == Activity.RESULT_OK){
            presenter.updateTravels();
        }else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void vacationWizard() {
        Intent wizard = new Intent(getActivity(), VacationWizard.class);
        wizard.putExtra(Constants.OPEN_AS_RESULT, true);
        startActivityForResult(wizard, RESULT_TRAVEL_WIZARD);
    }

    @Override
    public void openEditProfile() {
        startActivityForResult(new Intent(getActivity(), MyProfileEditActivity.class), RESULT_TRAVEL_WIZARD);
    }
}
