
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
            StringBuilder result = new StringBuilder();
            while (scanner.hasNext()) {
                arrayList.add(scanner.nextLine());
            }

            boolean inQuotes = false;
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).contains("&")) {
                    String line = arrayList.get(i);
                    arrayList.remove(i);
                    arrayList.add(i, line.replaceAll("&", "&amp;"));
                }
                if (arrayList.get(i).contains("<")) {
                    String line = arrayList.get(i);
                    arrayList.remove(i);
                    arrayList.add(i, line.replaceAll("<", "&lt;"));
                }
                if (arrayList.get(i).contains(">")) {
                    String line = arrayList.get(i);
                    arrayList.remove(i);
                    arrayList.add(i, line.replaceAll(">", "&gt;"));
                }

            }

            for (String x : arrayList) {
                if (!inQuotes) {
                    result.append("<tr><td>");
                }
                for (int i = 0; i < x.length(); i++) {
                    char character = x.charAt(i);

                    if (x.charAt(i) != ',' && character != '"') {
                        result.append(x.charAt(i));
                    } else if (!inQuotes && character == ',' && i != 0 && x.charAt(i - 1) == '"') {
                        result.append("<td>");
                    } else if (!inQuotes && character == ',') {
                        result.append("</td>").append("<td>");
                    } else if (!inQuotes && character == '"') {
                        inQuotes = true;
                    } else if (inQuotes && character != '"') {
                        result.append(character);
                    } else if (inQuotes) {
                        if (i != x.length() - 1 && x.charAt(i + 1) == '"') {
                            result.append(character);
                            i += 1;
                        } else {
                            inQuotes = false;
                            result.append("</td>");
                        }
                    }
                    if (i == x.length() - 1 && character == ',') {
                        result.append("</td>");
                    }
                }
                if (!inQuotes) {
                    result.append("</tr>");
                }
                if (inQuotes) {
                    result.append(" ");
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
