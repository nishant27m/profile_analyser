package com.ingd.pa.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
/**
 * This class contains all utility methods.
 */
public class CommonUtility {

    public static String SIMPLE_FORMAT = "MM/DD/YYYY HH:mm:SS";

    public static Date getDate(String date, String format) {
        DateFormat formatter = new SimpleDateFormat(format);
        return formatter.parse(date);

    }
}
