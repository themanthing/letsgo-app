package ru.mobilesoft.piligram.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;

import java.util.HashMap;

import ru.mobilesoft.piligram.mvp.view.VacationView;

/**
 * Created on 10.09.17.
 */

@InjectViewState
public class VacationPresenter extends BasePresenter<VacationView> {


    private final boolean isResult;

    public VacationPresenter(boolean isResult) {
        this.isResult = isResult;
    }

    // отправим данные на сервер)
    public void sendVacationData(HashMap<String, Object> values) {

        getViewState().showProgress();
        getApi().addVacation(values).subscribe(() -> {
            getViewState().hideProgress();
            if(!isResult) {
                getViewState().showMainScreen();
            }else{
                getViewState().returnSuccess();
            }
        }, throwable -> {
            getViewState().hideProgress();
            getViewState().showError(throwable.getMessage());
        });

    }
}
