package CFT;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TCFT {
    public static void main(String[] args) throws FileNotFoundException {
        ProgramArgs programArgs = Parser.parseArgs(args);

        SortingType fileType = programArgs.getSortType();
        SortDirection sortingDirection = programArgs.getSortDirection();
        ArrayList<?> list;
        if (fileType == SortingType.INTEGER && sortingDirection == SortDirection.ASCENDING) {
            ArrayList<Integer> listInt = FileWorking.readIntegers(programArgs.getInputFilePath());
            list = Sorting.sort(listInt, new IntegerComparator());
        } else if (fileType == SortingType.INTEGER && sortingDirection == SortDirection.DESCENDING) {
            ArrayList<Integer> listInt = FileWorking.readIntegers(programArgs.getInputFilePath());
            list = Sorting.sort(listInt, new IntegerComparator().reversed());
        } else if (fileType == SortingType.STRING && sortingDirection == SortDirection.ASCENDING) {
            ArrayList<String> lineList = FileWorking.readStrings(programArgs.getInputFilePath());
            list = Sorting.sort(lineList, new StringComparator());
        } else {
            ArrayList<String> lineList = FileWorking.readStrings(programArgs.getInputFilePath());
            list = Sorting.sort(lineList, new StringComparator().reversed());
        }

        FileWorking.writeInFile(list, programArgs.getOutputFilePath());
    }
}
