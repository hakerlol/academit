package CFT;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class FileWorking {
   /* public static <T> ArrayList reading(String nameInput) throws FileNotFoundException {
        ArrayList list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream(nameInput))) {

            while (scanner.hasNext()) {
                if()
                list.add(scanner.nextInt());
            }
        } catch (InputMismatchException ex) {
            System.out.println("File contains improper data for processing.");
        }
        return list;
    }*/


    public static ArrayList<Integer> readingInt(String nameInput) throws FileNotFoundException {
        ArrayList<Integer> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream(nameInput))) {

            while (scanner.hasNext()) {
                list.add(scanner.nextInt());
            }
        } catch (InputMismatchException ex) {
            System.out.println("File contains improper data for processing.");
        }
        return list;
    }

    public static void writingInt(ArrayList<Integer> list, String nameOutput) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(nameOutput)) {
            for (int x : list) {
                String inFile = Integer.toString(x);
                writer.println(inFile);
            }
        }
    }

    public static ArrayList<String> readingString(String nameInput) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream(nameInput))) {
            while (scanner.hasNext()) {
                list.add(scanner.nextLine());
            }
        } catch (InputMismatchException ex) {
            System.out.println("File contains improper data for processing.");
        }
        return list;
    }

    public static void writingString(ArrayList<String> list) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter("output.txt")) {
            for (String x : list) {
                writer.println(x);
            }
        }
    }
}