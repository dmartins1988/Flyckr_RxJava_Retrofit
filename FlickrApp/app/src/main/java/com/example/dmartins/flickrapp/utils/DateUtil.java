package com.example.dmartins.flickrapp.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by davidmartins on 27/11/2016.
 */

public class DateUtil
{

    private static final String dateFormat = "dd/MM/yyyy";

    public static String convertDateToFormat(long timeInMillis) {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMillis);
        return formatter.format(calendar.getTime());
    }
}
