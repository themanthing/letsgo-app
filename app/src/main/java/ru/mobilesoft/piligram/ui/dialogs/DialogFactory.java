package ru.mobilesoft.piligram.ui.dialogs;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;

import java.util.Date;

import ru.mobilesoft.piligram.R;

/**
 * Created on 27.01.17.
 * Простые диалоги
 */

public final class DialogFactory {

    public static AlertDialog.Builder getBuilder(Context context) {
        return new AlertDialog.Builder(context, R.style.AlertDialogTheme);
    }

    public static void showButtonTitleDialog(Context context,
                                             String title,
                                             String message,
                                             String button,
                                             DialogInterface.OnClickListener buttonClickListener) {
        getBuilder(context).setTitle(title)
                .setMessage(message)
                .setPositiveButton(button, buttonClickListener)
                .setCancelable(false)
                .show();
    }

    public static void showButtonDialog(Context context,
                                        String message,
                                        String button,
                                        DialogInterface.OnClickListener buttonClickListener) {
        getBuilder(context).setMessage(message)
                .setPositiveButton(button, buttonClickListener)
                .setCancelable(false)
                .show();
    }

    public static void showYesNoDialog(Context context,
                                       CharSequence message,
                                       CharSequence yesButton,
                                       CharSequence noButton,
                                       DialogInterface.OnClickListener yesButtonClickListener,
                                       DialogInterface.OnClickListener noButtonClickListener) {
        getBuilder(context).setMessage(message)
                .setPositiveButton(yesButton, yesButtonClickListener)
                .setNegativeButton(noButton, noButtonClickListener)
                .setCancelable(false)
                .show();
    }

    public static void showSimpleOkErrorDialog(Context context,
                                               CharSequence title,
                                               CharSequence message) {
        AlertDialog.Builder builder = getBuilder(context);
        if (!TextUtils.isEmpty(title)) {
            builder.setTitle(title);
        }
        if (!TextUtils.isEmpty(message)) {
            builder.setMessage(message);
        }
        builder.setPositiveButton(R.string.ok, null);
        builder.show();
    }

    public static void showSimpleOkErrorDialog(Context context,
                                               @StringRes int titleResource,
                                               @StringRes int messageResource) {
        showSimpleOkErrorDialog(context,
                                context.getString(titleResource),
                                context.getString(messageResource));
    }

    public static void showErrorDialog(Context context, @StringRes int messageResource) {
        showSimpleOkErrorDialog(context,
                                context.getString(R.string.error),
                                context.getString(messageResource));
    }

    public static void showErrorDialog(Context context, String message) {
        showSimpleOkErrorDialog(context, context.getString(R.string.error), message);
    }

    /**
     * Создать прогресс диалог
     *
     * @param context
     * @param message сообщение
     * @return созданные диалог, его можно будет потом показать/спрятать
     */
    public static ProgressDialog showProgressDialog(Context context, String message) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        if (!TextUtils.isEmpty(message)) {
            progressDialog.setMessage(message);
        } else {
            progressDialog.setMessage(context.getResources()
                                              .getString(R.string.message_please_wait));
        }
        progressDialog.show();
        return progressDialog;
    }

    /**
     * Показать диалог ожидания
     *
     * @param manager менеджер фрагментов
     * @param message сообвщение
     */
    public static void showOverlayDialog(FragmentManager manager, String message) {
        OverlayDialog dialog = new OverlayDialog();
        dialog.show(manager, OverlayDialog.class.getSimpleName());
    }

    /**
     * спрятать диалог ожидания
     *
     * @param manager менеджер фрагментов
     */
    public static void hideOverlayDialog(FragmentManager manager) {
        Fragment fragment = manager.findFragmentByTag(OverlayDialog.class.getSimpleName());
        if (fragment instanceof OverlayDialog) {
            OverlayDialog dialog = (OverlayDialog) fragment;
            dialog.dismiss();
        }
    }

    /**
     * LockScreenDialog
     *
     * @param context контекст
     * @return создаст диалог который лочит экрна на время работы
     */
    public static Dialog createScreenBlocker(Context context) {
        return new Dialog(context) {
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                getWindow().setBackgroundDrawable(new ColorDrawable(0));
                getWindow().requestFeature(Window.FEATURE_NO_TITLE);
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                setCancelable(false);
            }
        };
    }

    public static DatePickerDialog createDatePicker(Context context,
                                        DatePickerDialog.OnDateSetListener listener,
                                        Date minDate,
                                        Date maxDate) {
        DatePickerDialog dialog = new DatePickerDialog(context, listener, 1979, 1, 1);
        if (minDate != null){
            dialog.getDatePicker().setMinDate(minDate.getTime());
        }
        if (maxDate != null){
            dialog.getDatePicker().setMaxDate(maxDate.getTime());
        }
        return dialog;
    }
}
