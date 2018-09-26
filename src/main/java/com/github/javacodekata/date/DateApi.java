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
        Calendar calendarFrom = Calendar.getInstance();
        calendarFrom.setTime(date);

        calendarFrom.add(Calendar.DAY_OF_MONTH, -daysBefore);
        calendarFrom.set(Calendar.HOUR_OF_DAY, 0);
        calendarFrom.set(Calendar.MINUTE, 0);
        calendarFrom.set(Calendar.SECOND, 0);

        Calendar calendarTo = Calendar.getInstance();
        calendarTo.setTime(date);

        calendarTo.add(Calendar.DAY_OF_MONTH, 1);
        calendarTo.set(Calendar.HOUR_OF_DAY, 0);
        calendarTo.set(Calendar.MINUTE, 0);
        calendarTo.set(Calendar.SECOND, 0);

        Date from = calendarFrom.getTime();
        Date to = calendarTo.getTime();

        return new DateRange(from, to);
    }
}
