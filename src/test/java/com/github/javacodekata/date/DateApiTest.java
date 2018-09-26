package com.github.javacodekata.date;

import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class DateApiTest {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private DateApi dateApi;


    @Before
    public void setUp() throws Exception {
        dateApi = new DateApi();
    }


    @Test
    public void daysBetweenDates() throws Exception {
        Date origin = dateFormat.parse("2018-09-01 11:00:00");
        Date end = dateFormat.parse("2018-09-18 19:00:00");

        long daysBetween = dateApi.daysBetween(origin, end);

        assertThat(daysBetween, is(18));
    }


    @Test
    public void dateRangeSinceToday() throws Exception {
        Date september30_noon = dateFormat.parse("2018-09-30 12:00:00");

        DateRange range = dateApi.searchRangeSince(september30_noon, 10);

        Date september20_midnight = dateFormat.parse("2018-09-20 00:00:00");
        Date october_1_midnight = dateFormat.parse("2018-10-01 00:00:00");

        assertNotNull(range);
        assertThat(range.getFrom(), is(september20_midnight));
        assertThat(range.getTo(), is(october_1_midnight));
    }
}
