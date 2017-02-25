package CFT;


import java.util.ArrayList;


public class Sorting {

    public static ArrayList<Integer> sortInteger(ArrayList<Integer> array, int direction) {
        if (direction == 1) {
            for (int i = 1; i < array.size(); i++) {
                int temp = array.get(i);
                int j = i;

                if (temp < array.get(i - 1)) {
                    while ((j - 1) >= 0 && temp < array.get(j - 1)) {
                        array.set(j, j - 1);
                        j--;
                    }
                    array.set(j, temp);
                }
            }
            return array;
        } else if (direction == 0) {
            for (int i = 1; i < array.size(); i++) {
                int temp = array.get(i);
                int j = i;

                if (temp > array.get(i - 1)) {
                    while ((j - 1) >= 0 && temp > array.get(j - 1)) {
                        array.set(j, j - 1);
                        j--;
                    }
                    array.set(j, temp);
                }
            }
            return array;
        } else {
            System.out.println("Передан недопустимый параметр, список будет отсортирован по возрастанию");
            for (int i = 1; i < array.size(); i++) {
                int temp = array.get(i);
                int j = i;

                if (temp < array.get(i - 1)) {
                    while ((j - 1) >= 0 && temp < array.get(j - 1)) {
                        array.set(j, j - 1);
                        j--;
                    }
                    array.set(j, temp);
                }
            }
            return array;
        }
    }


    public static ArrayList<String> sortString(ArrayList<String> array, int direction) {
        if (direction == 1) {
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
        } else if (direction == 0) {
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
        } else {
            System.out.println("Передан недопустимый параметр, список будет отсортирован по возрастанию");
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
    }
}
