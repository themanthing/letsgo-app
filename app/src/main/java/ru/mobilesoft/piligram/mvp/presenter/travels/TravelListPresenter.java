package ru.mobilesoft.piligram.mvp.presenter.travels;

import com.arellomobile.mvp.InjectViewState;

import ru.mobilesoft.piligram.mvp.presenter.BasePresenter;
import ru.mobilesoft.piligram.mvp.view.TravelListView;
import timber.log.Timber;

/**
 * Created on 10/16/17.
 * презентер путешествий
 */

@InjectViewState
public class TravelListPresenter extends BasePresenter<TravelListView> {

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getApi().getTravelList(0).subscribe(travels -> {
            if (travels == null || travels.size() == 0){
                getViewState().showEmptyView(false);
            }else {
                getViewState().createOrUpdateAdapter(travels);
                getViewState().showList(false);
            }
        }, Timber::e);
    }



}
