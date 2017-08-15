package ru.mobilesoft.piligram.mvp.presenter;

import java.util.HashMap;

import ru.mobilesoft.piligram.mvp.view.BaseView;

/**
 * Created on 15.08.17.
 */

public abstract class BaseWizardPresenter<V extends BaseView> extends BasePresenter<V> {

    private HashMap<String, Object> wizardParam = new HashMap<>();

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
