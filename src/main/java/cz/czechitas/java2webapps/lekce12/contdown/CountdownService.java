package cz.czechitas.java2webapps.lekce12.contdown;

import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 * @author Filip Jirsák
 */
@Service
public class CountdownService {
    private final Clock clock;

    public CountdownService() {
        this(Clock.systemDefaultZone());
    }

    public CountdownService(Clock clock) {
        this.clock = clock;
    }

    public LocalDate today() {
        return LocalDate.now(clock);
    }

    public LocalDate nextChristmas() {
        LocalDate today = today();
        LocalDate christmas = today.withDayOfMonth(24).withMonth(12);
        if (!today.isAfter(christmas)) {
            return christmas;
        }
        return today.plusYears(1L).withDayOfMonth(24).withMonth(12);
    }

    public int daysToChristmas() {
        LocalDate today = today();
        LocalDate christmas = nextChristmas();
        return (int) today.until(christmas, ChronoUnit.DAYS);
    }

}
