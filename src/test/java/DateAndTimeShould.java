import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import time.DateAndTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateAndTimeShould {

    @Test
    void get_current_time() {
        // Before Java 8 :
        Date date = new Date();
        System.out.println(date);

        // From Java 8 :
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalDateTime aFutureTime = LocalDateTime.of(2033, 10, 23, 16, 42);
        Assertions.assertThat(aFutureTime).isAfter(localDateTime);
    }

    @Test
    void get_5_hours_ago() {
        // Before Java 8 :
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.HOUR, -5);
        final Date time = calendar.getTime();
        System.out.println(time);
        
        // From Java 8 :
        LocalDateTime fiveHoursAgo = LocalDateTime.now().minusHours(5);
        System.out.println(fiveHoursAgo);
    }

    @Test
    void determine_if_a_day_is_in_weekend() {
        DateAndTime dateAndTime = new DateAndTime();
        LocalDate sunday = LocalDate.of(2022, 10, 23);
        LocalDate monday = LocalDate.of(2022, 10, 24);

        boolean weekend = dateAndTime.isWeekend(sunday);
        boolean notWeekend = dateAndTime.isWeekend(monday);

        Assertions.assertThat(weekend).isTrue();
        Assertions.assertThat(notWeekend).isFalse();
    }
}
