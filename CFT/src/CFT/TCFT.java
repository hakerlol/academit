package CFT;

import java.io.FileNotFoundException;

public class TCFT {
    public static void main(String[] args) throws FileNotFoundException {
        Sorting.sortINT(FileWorking.readingInt(Parsing.chooseSort(args).getInputFileName()), Integer::compareTo);
        FileWorking.writingInt(Sorting.sortINT(FileWorking.readingInt(Parsing.chooseSort(args).getInputFileName()), Integer::compareTo), Parsing.chooseSort(args).getOutputFileName());
    }
}
