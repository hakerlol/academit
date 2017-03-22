
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;


public class CSV {
    public static void main(String[] args) throws UnsupportedEncodingException {

        try (Scanner scanner = new Scanner(new FileInputStream("table.txt")); PrintWriter writer = new PrintWriter("output.txt")) {

            ArrayList<String> arrayList = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            while (scanner.hasNext()) {
                arrayList.add(scanner.nextLine());
            }

            boolean inQuotes = false;

            for (String x : arrayList) {

                for (int i = 0; i < x.length(); i++) {
                    char c = x.charAt(i);

                    if (c == '<') {
                        result.append("&lt;");
                    } else if (c == '>') {
                        result.append("&gt;");
                    } else if (c == '&') {
                        result.append("&amp;");
                    } else if (inQuotes) {
                        if (i == x.length() - 1 && c == '"') {
                            inQuotes = false;
                            result.append("</td></tr><br>");
                        } else if (c != '"') {
                            result.append(c);
                        } else if (i != x.length() - 1 && x.charAt(i + 1) == '"') {
                            result.append(c);
                            i += 1;
                        } else {
                            inQuotes = false;
                            result.append("</td>");
                        }
                    } else {
                        if (i == 0) {
                            result.append("<tr><td>").append(c);
                        } else if (c != ',' && c != '"' && i == x.length() - 1) {
                            result.append(c).append("</td></tr><br>");
                        } else if (c != ',' && c != '"') {
                            result.append(c);
                        } else if (c == ',' && i == x.length() - 1 && x.charAt(i - 1) == '"') {
                            result.append("<td></td></tr><br>");
                        } else if (c == ',' && i == x.length() - 1) {
                            result.append("</td><td></td></tr><br>");
                        } else if (c == ',' && x.charAt(i - 1) == '"') {
                            result.append("<td>");
                        } else if (c == ',') {
                            result.append("</td><td>");
                        } else {
                            inQuotes = true;
                        }
                    }
                }
            }

            String header = "<!DOCTYPE html><html><head><meta charset=\"UTF-8\"/><title>Таблица</title></head><body><table border=\"3\">";
            String end = "</table></body></html>";
            writer.print(header);
            writer.print(result);
            writer.print(end);

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }
}
