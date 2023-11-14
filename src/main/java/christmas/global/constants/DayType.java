package christmas.global.constants;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;

public enum DayType {
    WEEKDAY(Arrays.asList(
            DayOfWeek.SUNDAY,
            DayOfWeek.MONDAY,
            DayOfWeek.TUESDAY,
            DayOfWeek.WEDNESDAY,
            DayOfWeek.THURSDAY
    )),
    WEEKEND(Arrays.asList(
            DayOfWeek.FRIDAY,
            DayOfWeek.SATURDAY
    ));

    private final List<DayOfWeek> days;

    DayType(List<DayOfWeek> days) {
        this.days = days;
    }

    public static boolean isWeekDay(DayOfWeek target) {
        return findDayType(target).equals(WEEKDAY);
    }

    private static DayType findDayType(DayOfWeek target) {
        return Arrays.stream(DayType.values())
                .filter(dayOfWeek -> dayOfWeek.equals(target))
                .findAny()
                .orElseThrow(() -> new IllegalStateException());
    }
}
