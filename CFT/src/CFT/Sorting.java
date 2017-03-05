package CFT;


import java.util.ArrayList;
import java.util.Comparator;


public class Sorting {
    public static <T> ArrayList<T> sort(ArrayList<T> list, Comparator<T> comparator) {
        for (int i = 1; i < list.size(); i++) {
            T temp = list.get(i);
            int j = i;

            if (comparator.compare(list.get(j), list.get(i - 1)) < 0) {
                while ((j - 1) >= 0 && (comparator.compare(temp, list.get(j - 1)) < 0)) {
                    list.set(j, list.get(j - 1));
                    j--;
                }
                list.set(j, temp);
            }
        }
        return list;
    }
}
