package ru.mobilesoft.piligram.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;

import java.util.HashMap;

import ru.mobilesoft.piligram.mvp.view.BaseView;
import ru.mobilesoft.piligram.mvp.view.Wizard;
import ru.mobilesoft.piligram.mvp.view.WizardView;

/**
 * Created on 15.08.17.
 */
@InjectViewState
public class WizardPresenter extends BasePresenter<WizardView> {

    private HashMap<String, Object> wizardParam = new HashMap<>();

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().initViewPager();
    }

    public void setValue(String key, Object value) {
        wizardParam.put(key, value);
    }

    public Object getValue(String key) {
        return wizardParam.get(key);
    }

    public boolean containsKey(String name) {
        return wizardParam.containsKey(name);
    }
}
