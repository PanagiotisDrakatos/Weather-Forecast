package com.plugin.awesomejava.Location;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class LocationInfo {

    private static final String STRING_URL = "http://checkip.amazonaws.com";

    public static String getIp() {
        BufferedReader in = null;
        URL whatismyip = null;
        String ip = null;
        try {
            whatismyip = new URL(STRING_URL);

            in = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));
            ip = in.readLine();
         
            return ip;
        } catch (Exception ex) {
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return ip;
    }

    public static String DayName() {
        try {
            DateObjects localdate = GetLocalDate();
            String dateString = String.format("%d-%d-%d", localdate.year, localdate.month, localdate.day);

            Date date = new SimpleDateFormat("yyyy-M-d").parse(dateString);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int day = cal.get(Calendar.DAY_OF_WEEK);

            String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);

            return dayOfWeek + " " + day + "TH";
        } catch (ParseException ex) {
            System.out.println(ex.toString());
            return Error.LISTVALUES.getDescription();
        }
    }

    public static int DayCode() {
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek;
    }

    private static DateObjects GetLocalDate() {
        final Date date = new Date();
        final LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        final int year = localDate.getYear();
        final int month = localDate.getMonthValue();
        final int day = localDate.getDayOfMonth();

        return new DateObjects(year, month, day);

    }

    private static class DateObjects {

        private int year;
        private int month;
        private int day;

        public DateObjects() {

        }

        public DateObjects(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

    }
}
