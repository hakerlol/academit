import java.util.ArrayList;
import java.util.List;

public class TestLines {
    public static String[] Test(String line) {
        return line.split(",");
    }

    public static List<String> Separators(String line) {
        char[] charLine = line.toCharArray();
        boolean inCell = false;
        boolean inQuotes = false;
        List<String> cells = new ArrayList<>();

        int index = 0;
        String result = null;
        for(int i = 0; i < charLine.length; i++){
            if(charLine[i] == '"'){
                inQuotes = true;
            }
            if(charLine[i] == ','){
                result =line.substring(index, i);
                cells.add(result);
                index = i;
            }
        }
        return cells;
    }

}
