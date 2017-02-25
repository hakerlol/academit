package CFT;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static CFT.Sorting.*;

public class TCFT {
    public static void main(String[] args) throws FileNotFoundException {
         if(args.length == 4){
             FileWorking.readingInt(args[0]);
             SortingType.chooseSortingType(args[0], args[2] , args[3]);
         }
    }
}
