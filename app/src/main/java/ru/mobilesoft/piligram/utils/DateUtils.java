package ru.mobilesoft.piligram.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * Created on 8/16/17.
 */

public class DateUtils {

    private static final SimpleDateFormat DATE_FORMAT =
            new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

    private static final SimpleDateFormat MONTH_NAME_AND_YEAR =
            new SimpleDateFormat("MMMM yyyy", Locale.getDefault());

    public static String convertDateToString(Date date) {
        return DATE_FORMAT.format(date);
    }

    public static String convertDateToMonthAndYear(Date date){
        return MONTH_NAME_AND_YEAR.format(date);
    }

    public static Date createDate(int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        return calendar.getTime();
    }

    public static long getDateDiffInMilliseconds(Date beginDate, Date endDate) {
        long diff = endDate.getTime() - beginDate.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

}
