package ru.mobilesoft.piligram.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created on 8/16/17.
 */

public class DateUtils {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

    public static String convertDateToString(Date date){
        return DATE_FORMAT.format(date);
    }

}
