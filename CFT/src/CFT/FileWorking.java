package CFT;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class FileWorking {
    public static void writeInFile(ArrayList<?> list, String outputFilePath) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(outputFilePath)) {
            for (Object x : list) {
                writer.println(x);
            }
        }
    }

    public static ArrayList<Integer> readIntegers(String inputFilePath) throws FileNotFoundException {
        ArrayList<Integer> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream(inputFilePath))) {

            while (scanner.hasNext()) {
                list.add(scanner.nextInt());
            }
        } catch (InputMismatchException ex) {
            System.out.println("File contains improper data for processing.");
        }
        return list;
    }

    public static ArrayList<String> readStrings(String nameInput) throws FileNotFoundException {
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
}
