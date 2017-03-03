package CFT;


public enum SortingType {
    INTEGER, STRING;

    private static Enum fileType;

    public static Enum sortType(String s) {

        switch (s) {
            case ("-i"): {
                fileType = SortingType.INTEGER;
            }
            case ("-s"): {
                fileType = SortingType.STRING;
            }
            default: {
                throw new IllegalArgumentException("Неверно выбран тип сортирумеого элемента");
            }
        }

    }

    public static boolean SortDirection(String s) {

        switch (s) {
            case ("-a"): {
                return true;
            }
            case ("-d"): {
                return false;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }
}