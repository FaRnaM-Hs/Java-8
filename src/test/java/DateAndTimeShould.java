import org.junit.jupiter.api.Test;

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
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
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
}
