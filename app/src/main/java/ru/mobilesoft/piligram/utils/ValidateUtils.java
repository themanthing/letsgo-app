package ru.mobilesoft.piligram.utils;

import android.text.TextUtils;

/**
 * Created on 15.08.17.
 */

public class ValidateUtils {

    public static boolean validateEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) &&
                android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

}
