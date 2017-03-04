package CFT;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static CFT.SortDirection.ASCENDING;
import static CFT.SortDirection.DESCENDING;
import static CFT.SortingType.INTEGER;
import static CFT.SortingType.STRING;

public class TCFT {
    public static void main(String[] args) throws FileNotFoundException {

        Enum fileType = Parser.chooseSort(args).getSortType();
        Enum sortingDirection = Parser.chooseSort(args).getSortDirection();
        ArrayList<?> list;
        if(fileType == INTEGER && sortingDirection == ASCENDING){
           list =  FileWorking.readIntegers(Parser.chooseSort(args).getInputFileName());
         //  list = Sorting.sortFileObjects(list, IntegerComparator());
        } else if (fileType == INTEGER && sortingDirection == DESCENDING){
            list =  FileWorking.readIntegers(Parser.chooseSort(args).getInputFileName());
       //     list = Sorting.sortFileObjects(list, IntegerComparator());
        } else if (fileType == STRING && sortingDirection == ASCENDING){
            list =  FileWorking.readStrings(Parser.chooseSort(args).getInputFileName());
        }else {
            list =  FileWorking.readStrings(Parser.chooseSort(args).getInputFileName());
        }

        FileWorking.writeInFile(list, Parser.chooseSort(args).getOutputFileName());
    }
}
