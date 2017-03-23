
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;


public class CSV {
    public static void main(String[] args) throws UnsupportedEncodingException {

        try (Scanner scanner = new Scanner(new FileInputStream(args[0])); PrintWriter writer = new PrintWriter(args[1])) {

            ArrayList<String> arrayList = new ArrayList<>();
            while (scanner.hasNext()) {
                arrayList.add(scanner.nextLine());
            }

            boolean inQuotes = false;
            StringBuilder HTMLFile = new StringBuilder();
            for (String line : arrayList) {

                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);

                    if (c == '<') {
                        HTMLFile.append("&lt;");
                    } else if (c == '>') {
                        HTMLFile.append("&gt;");
                    } else if (c == '&') {
                        HTMLFile.append("&amp;");
                    } else if (inQuotes) {
                        if (i == line.length() - 1 && c != '"') {
                            HTMLFile.append(c).append("<br>");
                        } else if (i == line.length() - 1 && c == '"') {
                            inQuotes = false;
                            HTMLFile.append("</td></tr>");
                        } else if (c != '"') {
                            HTMLFile.append(c);
                        } else if (i != line.length() - 1 && line.charAt(i + 1) == '"') {
                            HTMLFile.append(c);
                            i += 1;
                        } else {
                            inQuotes = false;
                            HTMLFile.append("</td>");
                        }
                    } else {
                        if (i == 0 && i == line.length() - 1 && c == ',') {
                            HTMLFile.append("<tr><td></td></tr>");
                        } else if (i == 0 && c == ',' && line.charAt(i + 1) != ',' && line.charAt(i + 1) != '"') {
                            HTMLFile.append("<tr><td></td><td>");
                        } else if (i == 0 && c == ',') {
                            HTMLFile.append("<tr><td></td>");
                        } else if (i == 0) {
                            HTMLFile.append("<tr><td>").append(c);
                        } else if (c != ',' && c != '"' && i == line.length() - 1) {
                            HTMLFile.append(c).append("</td></tr>");
                        } else if (line.charAt(i - 1) == ',' && c == ',' && line.charAt(i + 1) != ',') {
                            HTMLFile.append("<td></td><td>");
                        } else if (c != ',' && c != '"') {
                            HTMLFile.append(c);
                        } else if (c == ',' && i == line.length() - 1 && line.charAt(i - 1) == '"') {
                            HTMLFile.append("<td></td></tr>");
                        } else if (c == ',' && i == line.length() - 1) {
                            HTMLFile.append("</td><td></td></tr>");
                        } else if (c == ',' && line.charAt(i - 1) == '"') {
                            HTMLFile.append("<td>");
                        } else if (c == ',' && line.charAt(i - 1) == ',') {
                            HTMLFile.append("<td></td>");
                        } else if (c == ',') {
                            HTMLFile.append("</td><td>");
                        } else {
                            inQuotes = true;
                        }
                    }
                }
            }

            String header = "<!DOCTYPE html><html><head><meta charset=\"UTF-8\"/><title>Таблица</title></head><body><table border=\"3\">";
            String end = "</table></body></html>";
            writer.print(header);
            writer.print(HTMLFile);
            writer.print(end);

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }
}
