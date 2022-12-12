package cz.czechitas.java2webapps.lekce12.contdown;

import org.junit.jupiter.api.Test;

import java.time.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class CountdownServiceTest {
    private final ZoneId zoneId = ZoneId.of("Europe/Prague");
    private final LocalTime noon = LocalTime.of(12, 0);

    @Test
    void today() {
        assertAll(
                () -> assertEquals(LocalDate.now(), new CountdownService().today()),
                () -> assertEquals(
                        LocalDate.of(2022, 1, 31),
                        new CountdownService(createFixedClock(2022, 1, 31)).today()
                )
        );
    }

    @Test
    void nextChristmas() {
        assertAll(
                () -> assertEquals(
                        LocalDate.of(2022, 12, 24),
                        new CountdownService(createFixedClock(2022, 1, 1)).nextChristmas()
                ),
                () -> assertEquals(
                        LocalDate.of(2022, 12, 24),
                        new CountdownService(createFixedClock(2022, 12, 1)).nextChristmas()
                ),
                () -> assertEquals(
                        LocalDate.of(2022, 12, 24),
                        new CountdownService(createFixedClock(2022, 12, 23)).nextChristmas()
                ),
                () -> assertEquals(
                        LocalDate.of(2022, 12, 24),
                        new CountdownService(createFixedClock(2022, 12, 24)).nextChristmas()
                ),
                () -> assertEquals(
                        LocalDate.of(2023, 12, 24),
                        new CountdownService(createFixedClock(2022, 12, 25)).nextChristmas()
                ),
                () -> assertEquals(
                        LocalDate.of(2023, 12, 24),
                        new CountdownService(createFixedClock(2022, 12, 31)).nextChristmas()
                )
        );
    }

    @Test
    void daysToChristmas() {
        assertAll(
                () -> assertEquals(
                        357,
                        new CountdownService(createFixedClock(2022, 1, 1)).daysToChristmas()
                ),
                () -> assertEquals(
                        23,
                        new CountdownService(createFixedClock(2022, 12, 1)).daysToChristmas()
                ),
                () -> assertEquals(
                        1,
                        new CountdownService(createFixedClock(2022, 12, 23)).daysToChristmas()
                ),
                () -> assertEquals(
                        0,
                        new CountdownService(createFixedClock(2022, 12, 24)).daysToChristmas()
                ),
                () -> assertEquals(
                        364,
                        new CountdownService(createFixedClock(2022, 12, 25)).daysToChristmas()
                ),
                () -> assertEquals(
                        358,
                        new CountdownService(createFixedClock(2022, 12, 31)).daysToChristmas()
                ),
                () -> assertEquals(
                        358,
                        new CountdownService(createFixedClock(2024, 1, 1)).daysToChristmas()
                )
        );
    }

    private Clock createFixedClock(int year, int month, int dayOfMonth) {
        LocalDate date = LocalDate.of(year, month, dayOfMonth);
        return createFixedClock(date);
    }

    private Clock createFixedClock(LocalDate date) {
        ZonedDateTime dateTime = ZonedDateTime.of(date, noon, zoneId);
        return Clock.fixed(dateTime.toInstant(), zoneId);
    }
}
