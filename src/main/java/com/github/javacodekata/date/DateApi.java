package com.github.javacodekata.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateApi {
    public long daysBetween(Date origin, Date end) {
        LocalDate localOrigin = origin.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localEnd = end.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return ChronoUnit.DAYS.between(localOrigin, localEnd);
    }


    public DateRange searchRangeSince(Date date, int daysBefore) {
        LocalDateTime dateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());

        ZonedDateTime fromDatetime = dateTime.minusDays(daysBefore).toLocalDate().atStartOfDay(ZoneId.systemDefault());
        ZonedDateTime toDatetime = dateTime.plusDays(1).toLocalDate().atStartOfDay(ZoneId.systemDefault());

        Date from = Date.from(fromDatetime.toInstant());
        Date to = Date.from((toDatetime.toInstant()));

        return new DateRange(from, to);
    }
}
