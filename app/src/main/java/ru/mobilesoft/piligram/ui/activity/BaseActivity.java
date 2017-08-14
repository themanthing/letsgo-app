package ru.mobilesoft.piligram.ui.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;

import com.arellomobile.mvp.MvpAppCompatActivity;

import butterknife.ButterKnife;
import ru.mobilesoft.piligram.R;
import ru.mobilesoft.piligram.mvp.view.BaseView;
import ru.mobilesoft.piligram.ui.dialogs.DialogFactory;

/**
 * Created on 8/7/17.
 */

public abstract class BaseActivity extends MvpAppCompatActivity implements BaseView {

    private Dialog progressDialog;
    private Dialog lockScreen;

    //@formatter:off
    protected abstract @LayoutRes int getLayout();
    //@formatter:on

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
    }

    @Override
    public void showError(CharSequence message) {

        String msg = getString(R.string.error_common);
        if (!TextUtils.isEmpty(message)) {
            msg = message.toString();
        }

        DialogFactory.showSimpleOkErrorDialog(this, getString(R.string.error), msg);
    }

    @Override
    public void showPush(CharSequence title, CharSequence message) {
        DialogFactory.showSimpleOkErrorDialog(this, title, message);
    }

    @Override
    public void requestPermission(String[] permissions, int requestCode) {
        /*if (PermissionUtils.checkPermission(this, permissions, requestCode)) {
            // значит все хорошо
            int[] grant = new int[permissions.length];
            for (int i = 0; i < grant.length; i++) {
                grant[i] = PackageManager.PERMISSION_GRANTED;
            }
            onRequestPermissionsResult(requestCode, permissions, grant);
        }*/
    }

    @Override
    public void showError(@StringRes int msgId) {
        showError(getString(msgId));
    }

    /*public void showNextActivity() {
        //startActivity();
        overridePendingTransition(R.anim.custom_slide_in_right, R.anim.custom_slide_out_left);
    }*/

    @SuppressWarnings("unused")
    protected void push(Fragment fragment, boolean addToBackStack, boolean animate) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        try {
            if (animate) {
                transaction.setCustomAnimations(R.anim.custom_slide_in_right,
                                                R.anim.custom_slide_out_left,
                                                R.anim.custom_slide_in_left,
                                                R.anim.custom_slide_out_right);
            }

            if (addToBackStack) {
                transaction.addToBackStack(fragment.getClass().getSimpleName());
            }
            transaction.replace(R.id.container, fragment, fragment.getClass().getSimpleName());
        } finally {
            transaction.commitAllowingStateLoss();
        }
    }

    @SuppressWarnings("unused")
    protected void pushToUp(Fragment fragment, boolean addToBackStack, boolean animate) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        try {
            if (animate) {
                transaction.setCustomAnimations(R.anim.custom_slide_in_bottom,
                                                0,
                                                0,
                                                R.anim.custom_slide_out_bottom);
            }

            if (addToBackStack) {
                transaction.addToBackStack(fragment.getClass().getSimpleName());
            }

            transaction.add(R.id.container, fragment);
        } finally {
            transaction.commitAllowingStateLoss();
        }
    }

    protected void pushFade(Fragment fragment, boolean addToBackStack, boolean animate) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        try {
            if (animate) {
                transaction.setCustomAnimations(R.anim.fade_in, 0, 0, R.anim.fade_out);
            }

            if (addToBackStack) {
                transaction.addToBackStack(fragment.getClass().getSimpleName());
            }

            transaction.add(R.id.container, fragment);
        } finally {
            transaction.commitAllowingStateLoss();
        }
    }

    /**
     * очистить back stack
     */
    @SuppressWarnings("unused")
    protected void cleanHistory() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        int count = fragmentManager.getBackStackEntryCount();
        for (int i = 0; i < count; ++i) {
            fragmentManager.popBackStack();
        }
    }

    @Override
    public void showProgress() {
        if (progressDialog == null) {
            progressDialog =
                    DialogFactory.showProgressDialog(this, getString(R.string.message_please_wait));
        }
    }

    @Override
    public void hideProgress() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
       /* if (requestCode == PermissionUtils.REQUEST_PERMISSION_CALL) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                callPresenter.permissionGranted();
            } else {
                callPresenter.permissionDenied();
            }
        }*/
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    protected void showLockScreen() {
        lockScreen = DialogFactory.createScreenBlocker(this);
        lockScreen.show();
    }

    protected void hideLockScreen() {
        if (lockScreen != null) {
            lockScreen.dismiss();
            lockScreen = null;
        }
    }
}
