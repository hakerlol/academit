
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;


public class CSV {
    public static void main(String[] args) throws UnsupportedEncodingException {

        try (Scanner scanner = new Scanner(new FileInputStream("table.txt")); PrintWriter writer = new PrintWriter("output.html")) {

            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList<String> newArrayList = new ArrayList<>();
            while (scanner.hasNext()) {
                arrayList.add("<td>" + scanner.nextLine() + "</td>");
                arrayList.add("</tr>");
            }
            for (String x : arrayList) {
                for (String z : TestLines.Test(x)) {
                    newArrayList.add("<td>" + z + "</td>");
                }
            }
            String header = "<!DOCTYPE html><html><head><meta charset = \"UTF-8\"/><title>Таблица</title></head><body><table border =\"3\"><tr>";
            String end = "</table></body></html>";
            writer.print(header);

            for (String x : newArrayList) {
                writer.println(x);
            }
            writer.print(end);

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }
}
