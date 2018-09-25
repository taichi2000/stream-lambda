package com.github.javacodekata.date;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateApi {
    public long daysBetween(Date origin, Date end) {
        LocalDate localOrigin = origin.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localEnd = end.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return ChronoUnit.DAYS.between(localOrigin, localEnd);
    }

    public DateRange searchRangeSince(Date date, int daysBefore){
        return null;
    }
}
