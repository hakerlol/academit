
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
                arrayList.add(scanner.nextLine());
            }
            int commaIndex = 0;
            int quoteIndex = 0;
            int shieldingQuote;
            boolean inQuotes = false;
            boolean newLine = true;

            for (String x : arrayList) {

                if (!inQuotes) {
                    newArrayList.add("<tr>");
                    commaIndex = 0;
                }
                for (int i = 0; i < x.length(); i++) {
                    if (x.charAt(i) == '"') {
                        inQuotes = true;
                        newLine = false;
                        quoteIndex = i + 1;
                    }
                    if (!inQuotes) {
                        if (newLine) {
                            if (i == x.length() - 1 && x.charAt(i) == ',') {
                                if (x.charAt(i - 1) == '"') {
                                    newArrayList.add("<td>" + "</td>");
                                } else {
                                    newArrayList.add("<td>" + x.substring(commaIndex, i) + "</td>" + "<td>" + "</td>");
                                    newLine = true;
                                    commaIndex = 0;
                                }
                            } else if (x.charAt(i) == ',' && x.charAt(i - 1) != '"') {
                                newArrayList.add("<td>" + x.substring(commaIndex, i) + "</td>");
                                commaIndex = i + 1;
                            } else if (i == x.length() - 1) {
                                newArrayList.add("<td>" + x.substring(commaIndex, i + 1) + "</td>");
                                newLine = true;
                                commaIndex = 0;
                            }
                        } else {
                            if (i == x.length() - 1 && x.charAt(i) == ',') {
                                if (x.charAt(i - 1) == '"') {
                                    newArrayList.add("<td>" + "</td>");
                                } else {
                                    newArrayList.add("<td>" + x.substring(commaIndex, i) + "</td>" + "<td>" + "</td>");
                                    newLine = true;
                                    commaIndex = 0;
                                }
                            } else if (x.charAt(i) == ',' && x.charAt(i - 1) != '"') {
                                newArrayList.add("<td>" + x.substring(commaIndex, i) + "</td>");
                                commaIndex = i + 1;
                            } else if (x.charAt(i) == ',' && x.charAt(i - 1) == '"') {
                                commaIndex = i + 1;
                            } else if (i == x.length() - 1) {
                                newArrayList.add("<td>" + x.substring(commaIndex, i + 1) + "</td>");
                                newLine = true;
                                commaIndex = 0;
                            }
                        }
                    }
                    if (!newLine && inQuotes) {
                        for (int j = quoteIndex; j < x.length(); j++) {
                            if (j < x.length() - 1 && x.charAt(j) == '"' && (x.charAt(j + 1) == '"')) {
                                shieldingQuote = j;
                                for (int k = shieldingQuote + 2; k < x.length(); k++) {
                                    if (k != x.length() - 1 && x.charAt(k) == '"' && ((x.charAt(k + 1) == ','))) {
                                        newArrayList.add("<td>" + x.substring(quoteIndex, shieldingQuote) + x.substring(shieldingQuote + 1, k) + "</td>");
                                        inQuotes = false;
                                        i = k;
                                        break;
                                    } else if (k == x.length() - 1 && x.charAt(k) == '"') {
                                        newArrayList.add("<td>" + x.substring(quoteIndex, shieldingQuote) + x.substring(shieldingQuote + 1, k) + "</td>");
                                        inQuotes = false;
                                        newLine = true;
                                        i = k;
                                        break;
                                    }
                                }
                                break;
                            } else if (x.charAt(j) == '"') {
                                newArrayList.add("<td>" + x.substring(quoteIndex, j) + "</td>");
                                inQuotes = false;
                                i = j;
                                break;
                            } else if (j == x.length() - 1) {
                                newArrayList.add("<td>" + x.substring(quoteIndex));
                                newLine = true;
                            }
                        }
                    }
                    if (newLine && inQuotes && i == 0) {
                        for (int j = 0; j < x.length(); j++) {
                            if (x.charAt(j) == '"') {
                                newArrayList.add(x.substring(0, j));
                                newLine = false;
                                inQuotes = false;
                                commaIndex = 0;
                                i = j;
                                break;
                            }
                        }
                    }

                }
                if (!inQuotes) {
                    newArrayList.add("</tr>");
                }
            }
            String header = "<!DOCTYPE html><html><head><meta charset=\"UTF-8\"/><title>Таблица</title></head><body><table border=\"3\">";
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
