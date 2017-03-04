package CFT;


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
                throw new IllegalArgumentException();
            }
        }
    }
}
