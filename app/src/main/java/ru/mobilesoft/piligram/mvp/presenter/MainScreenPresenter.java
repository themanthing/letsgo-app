package ru.mobilesoft.piligram.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;

import ru.mobilesoft.piligram.mvp.view.MainScreenView;

/**
 * Created on 8/7/17.
 */
@InjectViewState
public class MainScreenPresenter extends BasePresenter<MainScreenView> {

    /**
     * первое столкновение с миром)
     */
    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        showSearchView();
    }

    /**
     * переход на форму поиска можно сказать основная форма
     */
    public void showSearchView() {
        getViewState().showSearchForm();
    }

    /**
     * путешесвтия
     */
    public void showTravelsView() {
        getViewState().showMyTravels();
    }

    /**
     * профиль пользователя
     */
    public void showProfile() {
        getViewState().showMyProfile();
    }

    /**
     * закладки/избранное
     */
    public void showFavorite() {
        getViewState().showFavoriteForm();
    }

    /**
     * показать мои сообщения
     */
    public void showMyMessages() {
        getViewState().showMyMessage();
    }
}
