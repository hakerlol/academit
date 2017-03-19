
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
            int quoteAmount = 0;
            int shieldingQuote;
            boolean inQuotes = false;

            for (String x : arrayList) {
                if (!inQuotes) {
                    result.append("<tr>").append("<td>");
                }

                for (int i = 0; i < x.length(); i++) {
                    if (x.charAt(i) != ',' && x.charAt(i) != '"') {
                        result.append(x.charAt(i));
                    } else if (!inQuotes && x.charAt(i) == ',') {
                        result.append("</td>").append("<td>");
                    } else if (!inQuotes && x.charAt(i) == '"') {
                        quoteAmount++;
                        inQuotes = true;
                    } else if (inQuotes && x.charAt(i) != '"') {
                        result.append(x.charAt(i));
                    } else if (inQuotes && x.charAt(i) == '"') {
                        if (i != x.length() - 1 && x.charAt(i + 1) == '"') {
                            shieldingQuote = i;
                            quoteAmount++;
                            for (int j = shieldingQuote + 1; j < x.length(); j++) {
                                if (x.charAt(j) == '"') {
                                    quoteAmount++;
                                }
                                if (x.charAt(j) == '"' && ((j == x.length() - 1) || (x.charAt(j + 1) != '"' && quoteAmount % 2 == 0))) {
                                    result.append("</td>");
                                    inQuotes = false;
                                    i = j;
                                    break;
                                } else if (j != shieldingQuote) {
                                    result.append(x.charAt(j));
                                }
                            }
                        } else {
                            inQuotes = false;
                            result.append("</td>");
                        }
                        quoteAmount = 0;
                    }
                }
                if (!inQuotes) {
                    result.append("</tr>");
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
