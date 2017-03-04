package CFT;


public enum SortingType {
    INTEGER, STRING;

    public static SortingType sortType(String s) {

        switch (s) {
            case "-i":
                return INTEGER;

            case "-s":
                return STRING;

            default:
                throw new IllegalArgumentException("Неверно выбран тип сортирумеого элемента");

        }

    }
}