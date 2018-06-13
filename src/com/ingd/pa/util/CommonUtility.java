package com.ingd.pa.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;

/**
 * This class contains all utility methods.
 */
public class CommonUtility {

    public static String SIMPLE_FORMAT = "dd-MM-yyyy HH:mm:ss";

    public static String SIMPLE_DATE = "dd-MM-yyyy";

    public static Date getDate(String date, String format) throws Exception {
        DateFormat formatter = new SimpleDateFormat(format);
        return formatter.parse(date);
    }

    public static String getDateInString(Date date, String format) throws Exception {
        DateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }

    public static Date getFirstDate(String month, String year) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(year), monthStringToInt(month), 1);
        return calendar.getTime();
    }

    public static Date getLastDate(String month, String year) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(year), monthStringToInt(month), 1);
        int lastDate = calendar.getActualMaximum(Calendar.DATE);
        calendar.set(Calendar.DATE, lastDate);
        return calendar.getTime();
    }

    private static int monthStringToInt(String month) throws Exception {
        int monthInt;
        if (month.contains("Jan")) {
            monthInt = Integer.valueOf(Calendar.JANUARY);
        }
        else if (month.contains("Feb")) {
            monthInt = Integer.valueOf(Calendar.FEBRUARY);
        }
        else if (month.contains("Mar")) {
            monthInt = Integer.valueOf(Calendar.MARCH);
        }
        else if (month.contains("Apr")) {
            monthInt = Integer.valueOf(Calendar.APRIL);
        }
        else if (month.contains("May")) {
            monthInt = Integer.valueOf(Calendar.MAY);
        }
        else if (month.contains("Jun")) {
            monthInt = Integer.valueOf(Calendar.JUNE);
        }
        else if (month.contains("Jul")) {
            monthInt = Integer.valueOf(Calendar.JULY);
        }
        else if (month.contains("Aug")) {
            monthInt = Integer.valueOf(Calendar.AUGUST);
        }
        else if (month.contains("Sep")) {
            monthInt = Integer.valueOf(Calendar.SEPTEMBER);
        }
        else if (month.contains("Oct")) {
            monthInt = Integer.valueOf(Calendar.OCTOBER);
        }
        else if (month.contains("Nov")) {
            monthInt = Integer.valueOf(Calendar.NOVEMBER);
        }
        else if (month.contains("Dec")) {
            monthInt = Integer.valueOf(Calendar.DECEMBER);
        }
        else {
            throw new Exception("Invalid month : "+month);
        }
        //Similar to other 11 months

        return monthInt;

    }


    public static void main(String[] args) throws Exception {
        System.out.println("Date : "+CommonUtility.getDate("31-12-2100 10:22:33", "dd-MM-yyyy HH:mm:ss"));
    }

}
