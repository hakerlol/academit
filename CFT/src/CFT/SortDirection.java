package CFT;

import java.util.Comparator;

public enum SortDirection {
    ASCENDING, DESCENDING;

    public static SortDirection sortDirection(String s) {

        switch (s) {
            case ("-a"): {
                return ASCENDING;
            }
            case ("-d"): {
                return DESCENDING;
            }
            default: {
                throw new IllegalArgumentException("Неверно выбрано направление сортировки");
            }
        }
    }

    public static <T> Comparator<T> getDirection(SortDirection direction, Comparator<T> comparator) {
        if (direction == SortDirection.ASCENDING) {
            return comparator;
        } else {
            return comparator.reversed();
        }
    }
}
