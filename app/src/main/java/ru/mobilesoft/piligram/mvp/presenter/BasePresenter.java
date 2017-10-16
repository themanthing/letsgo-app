package ru.mobilesoft.piligram.mvp.presenter;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import ru.mobilesoft.piligram.api.Api;
import ru.mobilesoft.piligram.api.ApiImpl;

/**
 * Created on 8/7/17.
 */

public abstract class BasePresenter<V extends MvpView> extends MvpPresenter<V> {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    protected void addDisposable(@NonNull Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    protected void removeDisposable(@NonNull Disposable disposable) {
        compositeDisposable.remove(disposable);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }

    protected Api getApi(){
        return ApiImpl.getInstance();
    }

}