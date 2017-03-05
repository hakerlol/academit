import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TEEEEST {

    public static <T> void sortINT(ArrayList<T> list, Comparator<T> comparator) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); ++j) {
                if (comparator.compare(list.get(j), list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            T temp = list.get(i);
            //остальное
        }
    }


    public static int[] sortAscending(int[] array) {


        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;

            if (temp < array[i - 1]) {
                while ((j - 1) >= 0 && temp < array[j - 1]) {
                    array[j] = array[j - 1];
                    j--;
                }
                array[j] = temp;
            }
        }
        return array;
    }

    public static int[] sortDescending(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;

            if (temp > array[i - 1]) {
                while ((j - 1) >= 0 && temp > array[j - 1]) {
                    array[j] = array[j - 1];
                    j--;
                }
                array[j] = temp;
            }
        }
        return array;
    }

    public static ArrayList<String> sortAscending(ArrayList<String> array) {

        for (int i = 1; i < array.size(); i++) {
            String temp = array.get(i);
            int j = i;

            if (temp.compareTo(array.get(i - 1)) < 0) {
                while ((j - 1) >= 0 && temp.compareTo(array.get(j - 1)) < 0) {
                    array.set(j, array.get(j - 1));
                    j--;
                }
                array.set(j, temp);
            }
        }
        return array;
    }

    public static ArrayList<String> sortDescending(ArrayList<String> array) {

        for (int i = 1; i < array.size(); i++) {
            String temp = array.get(i);
            int j = i;

            if (temp.compareTo(array.get(i - 1)) > 0) {
                while ((j - 1) >= 0 && temp.compareTo(array.get(j - 1)) > 0) {
                    array.set(j, array.get(j - 1));
                    j--;
                }
                array.set(j, temp);
            }
        }
        return array;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String[] array = {"мама", "мыла", "раму", "около", "подъезда", "вместо", "прогулки", "по", "парку"};
        ArrayList<String> lineArray = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            lineArray.add(i, array[i]);
        }
        for (String x : sortAscending(lineArray)) {
            System.out.println(x);
        }

    }
}
