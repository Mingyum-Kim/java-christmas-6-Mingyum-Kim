package christmas.global.constants;

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
}
