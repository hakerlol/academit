package CFT;

import java.io.FileNotFoundException;
import java.util.ArrayList;




public class TCFT {
    public static void main(String[] args) throws FileNotFoundException {
        ProgramArgs programArgs = Parser.parseArgs(args);

        Enum fileType = programArgs.getSortType();
        Enum sortingDirection = programArgs.getSortDirection();
        ArrayList<?> list;
        if(fileType == SortingType.INTEGER && sortingDirection == SortDirection.ASCENDING){
           list =  FileWorking.readIntegers(programArgs.getInputFilePath());
          // list = Sorting.sort(list, Integer::compareTo);
        } else if (fileType == SortingType.INTEGER && sortingDirection == SortDirection.DESCENDING){
            list =  FileWorking.readIntegers(programArgs.getInputFilePath());
         //   list = Sorting.sort(list, IntegerComparator());
        } else if (fileType == SortingType.STRING && sortingDirection == SortDirection.ASCENDING){
            list =  FileWorking.readStrings(programArgs.getInputFilePath());
        }else {
            list =  FileWorking.readStrings(programArgs.getInputFilePath());
        }

        FileWorking.writeInFile(list, programArgs.getOutputFilePath());
    }
}
