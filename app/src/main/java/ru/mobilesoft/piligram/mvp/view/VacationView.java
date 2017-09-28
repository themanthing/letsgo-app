package ru.mobilesoft.piligram.mvp.view;

import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created on 10.09.17.
 */
@StateStrategyType(SkipStrategy.class)
public interface VacationView extends BaseView {

    void showMainScreen();

    void returnSuccess();
}
