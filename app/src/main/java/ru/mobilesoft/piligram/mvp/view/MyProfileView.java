package ru.mobilesoft.piligram.mvp.view;

import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import ru.mobilesoft.piligram.model.Vacation;

/**
 * Created on 9/27/17.
 */

public interface MyProfileView extends BaseView {

    void showMyName(String name, String parentName);

    void createVacationAdapter(List<Vacation> vacations);

    void showDefaultAvatar(String sex);

    void showAvatar(String avatarUrl);

    @StateStrategyType(SkipStrategy.class)
    void vacationWizard();

    @StateStrategyType(SkipStrategy.class)
    void openEditProfile();
}
