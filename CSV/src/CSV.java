
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;


public class CSV {
    public static void main(String[] args) throws UnsupportedEncodingException {

        try (Scanner scanner = new Scanner(new FileInputStream(args[0])); PrintWriter writer = new PrintWriter(args[1])) {

            if (args.length == 2) {

                ArrayList<String> arrayList = new ArrayList<>();
                while (scanner.hasNext()) {
                    arrayList.add(scanner.nextLine());
                }

                boolean inQuotes = false;
                StringBuilder tableHtml = new StringBuilder();
                for (String line : arrayList) {
                    if (!inQuotes) {
                        tableHtml.append("<tr><td>");
                    }

                    for (int i = 0; i < line.length(); i++) {
                        char c = line.charAt(i);

                        if (c == '<') {
                            tableHtml.append("&lt;");
                        } else if (c == '>') {
                            tableHtml.append("&gt;");
                        } else if (c == '&') {
                            tableHtml.append("&amp;");
                        } else if (inQuotes) {
                            if (i == line.length() - 1 && c != '"') {
                                tableHtml.append(c).append("<br>");
                            } else if (c != '"') {
                                tableHtml.append(c);
                            } else if (i != line.length() - 1 && line.charAt(i + 1) == '"') {
                                tableHtml.append(c);
                                i += 1;
                            } else {
                                inQuotes = false;
                            }
                        } else {
                            if (i == 0 && i == line.length() - 1 && c == ',') {
                                break;
                            } else if (i == 0 && c == ',' && line.charAt(i + 1) != ',' && line.charAt(i + 1) != '"') {
                                tableHtml.append("</td><td>");
                            } else if (c == ',') {
                                tableHtml.append("</td><td>");
                            } else if (i == 0 && c != '"') {
                                tableHtml.append(c);
                            } else if (c != '"') {
                                tableHtml.append(c);
                            } else {
                                inQuotes = true;
                            }
                        }
                    }
                    if (!inQuotes) {
                        tableHtml.append("</td></tr>");
                    }
                }

                String header = "<!DOCTYPE html><html><head><meta charset=\"UTF-8\"/><title>Таблица</title></head><body><table border=\"3\">";
                String end = "</table></body></html>";
                writer.print(header);
                writer.print(tableHtml);
                writer.print(end);

            } else {
                System.out.printf("%s%n%s%n%s%n%", "Неверное количество аргументов, проверьте вводимые аргументы",
                        "Первый аргумент - имя файла в формате .txt, в котором лежит исходная таблица", "Второй аргумент - имя файла в формате .html");
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }
}
