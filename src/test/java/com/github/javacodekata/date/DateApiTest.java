package com.github.javacodekata.date;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
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

        assertThat(daysBetween, is(0L)); //Dummy implementation
    }
}
