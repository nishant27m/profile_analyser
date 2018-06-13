package com.ingd.pa.util;

import java.text.SimpleDateFormat;
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
        return null;
    }

    public static Date getLastDate(String month, String year) {
        return null;
    }


}
