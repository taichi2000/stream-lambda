package com.github.javacodekata.date;

import java.util.Calendar;
import java.util.Date;

public class DateApi {
    private static final int SECONDS = 60;
    private static final int MINUTES = 60;
    private static final int HOURS = 24;
    private static final long DAY_IN_MILLIS = 1000L * SECONDS * MINUTES * HOURS;


    public long daysBetween(Date origin, Date end) {
        Calendar calendarOrigin = Calendar.getInstance();
        calendarOrigin.setTime(origin);

        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.setTime(end);

        return (calendarEnd.getTimeInMillis() - calendarOrigin.getTimeInMillis()) / DAY_IN_MILLIS;
    }

    public DateRange searchRangeSince(Date date, int daysBefore){
        return null;
    }
}
