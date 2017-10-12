package ru.mobilesoft.piligram.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;

import java.util.Date;

import ru.mobilesoft.piligram.model.Travel;
import ru.mobilesoft.piligram.mvp.view.TravelWizardView;
import ru.mobilesoft.piligram.utils.DateUtils;
import timber.log.Timber;

/**
 * Created on 10/11/17.
 */

@InjectViewState
public class TravelPresenter extends BasePresenter<TravelWizardView> {

    public void create() {
        Travel travel = new Travel();

        travel.setBeginDate(new Date());
        travel.setEndDate(new Date());
        travel.setDescription("бла бла бла");
        travel.setTitle("Бла бла");

        addDisposable(getApi().createTravel(travel).subscribe(() -> {
            Timber.d("мы создали путешествие, надо обновить список моих путешествий, тупо добавив в него");
        }, throwable -> {
            Timber.e("это фиаско братан", throwable);
        }));
    }
}
