package ru.mobilesoft.piligram.ui.dialogs;

import android.content.Context;
import android.widget.Toast;

public class Toasts {
    public static void toast(Context context, int message, int duration) {
        toast(context, context.getString(message), duration);
    }

    public static void toast(Context context, String message, int duration) {
        Toast.makeText(context, message, duration).show();
    }
}
