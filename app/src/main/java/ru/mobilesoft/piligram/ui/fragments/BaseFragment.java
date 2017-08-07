package ru.mobilesoft.piligram.ui.fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;

import butterknife.ButterKnife;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.mvp.view.BaseView;
import ru.mobilesoft.piligram.ui.dialogs.DialogFactory;

/**
 * Created by toni on 8/7/17.
 */

public abstract class BaseFragment extends MvpAppCompatFragment implements BaseView {

    private Dialog progressDialog;

    //@formatter:off
    protected abstract @LayoutRes int getLayout();
    //@formatter:on

    @Override
    public void showError(CharSequence message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError(@StringRes int msgId) {
        showError(getString(msgId));
    }

    @Override
    public void showPush(CharSequence title, CharSequence message) {
        DialogFactory.showSimpleOkErrorDialog(getContext(), title, message);
    }

    @Override
    public void requestPermission(String[] permissions, int requestCode) {

        /*if (PermissionUtils.checkPermission(getActivity(), permissions, requestCode)) {

            int[] grant = new int[permissions.length];
            for (int i = 0; i < grant.length; i++) {
                grant[i] = PackageManager.PERMISSION_GRANTED;
            }

            getActivity().onRequestPermissionsResult(requestCode, permissions, grant);
        }*/
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayout(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void showProgress() {
        if (progressDialog == null && getContext() != null) {
            progressDialog = DialogFactory.showProgressDialog(getContext(),
                                                              getString(R.string.message_please_wait));
        }
    }

    @Override
    public void hideProgress() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }
}