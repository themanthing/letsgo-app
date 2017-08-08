package ru.mobilesoft.piligram.mvp.view;

import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created on 8/7/17.
 */

public interface MainScreenView extends BaseView {

    //@StateStrategyType(SkipStrategy.class)
    void showSearchForm();

    /**
     * показать Закладки
     */
    void showFavoriteForm();

    /**
     * показать мои сообщения
     */
    void showMyMessage();

    /**
     * показать мои путеществия
     */
    void showMyTravels();
}
