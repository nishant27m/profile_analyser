package com.ingd.pa.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
/**
 * This class contains all utility methods.
 */
public class CommonUtility {

    public static String SIMPLE_FORMAT = "MM/DD/YYYY HH:mm:SS";

    public static String SIMPLE_DATE = "MM/DD/YYYY";

    public static Date getDate(String date, String format) throws Exception {
        DateFormat formatter = new SimpleDateFormat(format);
        return formatter.parse(date);
    }

    public static Date getFirstDate(String month, String year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(year), Integer.parseInt(month), 1);
        return calendar.getTime();
    }

    public static Date getLastDate(String month, String year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(year), Integer.parseInt(month), 1);
        int lastDate = calendar.getActualMaximum(Calendar.DATE);
        calendar.set(Calendar.DATE, lastDate);
        return calendar.getTime();
    }


}
