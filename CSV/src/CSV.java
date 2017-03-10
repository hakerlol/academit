import sun.text.normalizer.UTF16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;


public class CSV {
    public static void main(String[] args) throws UnsupportedEncodingException {
        try (Scanner scanner = new Scanner(new FileInputStream("table.txt")); PrintWriter writer = new PrintWriter("output.html")) {
            int index = 0;
            ArrayList<String> arrayList = new ArrayList<>();
            while (scanner.hasNext()) {
                scanner.useDelimiter(",");
                while (scanner.hasNextLine()) {
                    String cell = scanner.next();
                    if (index == 0) {
                        arrayList.add("<td>" + cell + "</td>");
                    } else if (index == 1) {
                        arrayList.add("<td>" + cell + "</td>");
                    } else {
                        arrayList.add("<td>" + cell + "</td><tr>");
                    }
                    ++index;
                }
                index = 0;
                arrayList.add("</tr>");
            }

            String header = "<!DOCTYPE html>\n<html>\n<head>\n<meta charset = \"UTF-8\"/>\n<title>Таблица</title>\n</head>\n<body><table border =\"3\"><tr>";
            String end = "</tr></table>\n</body>\n</html>";
            writer.print(header);

            for (String x : arrayList) {
                writer.println(x);
            }
            writer.print(end);

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }
}
