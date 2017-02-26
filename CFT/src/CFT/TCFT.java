package CFT;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class TCFT {
    public static void main(String[] args)  {
       /* public static ArrayList chooseSortingType(String inputFileName, Enum x, String direction) throws FileNotFoundException {

            if (x.equals(NUMBERS)) {
                return Sorting.sortInteger(FileWorking.readingInt(inputFileName), SortDirection(direction));
            } else if (x.equals(STRINGS)) {
                return Sorting.sortString(FileWorking.readingString(inputFileName), SortDirection(direction));
            } else {System.out.println("Недопустимая команда");
                return null;
            }
        }*/
        try {
            if (args.length == 4) {
                FileWorking.readingInt(args[0]);
             //   FileWorking.writingInt(SortingType.chooseSortingType(args[0], SortingType("-s"), args[3] ), );
            }else {
                System.out.printf("%s%n%s%n%s%n%s%n%s%n","Справка", "Первым аргументом должно быть имя исходного файла",
                        "Вторым аргументом должно быть имя файла, в который будет происходить сохранение",
                        "Третий аргумент: -s - сортировка строк, -i - сортировка чисел",
                        "Четвертый аргумент -a - сортировка по возрастанию, -d - сортировка по убыванию");

            }
        } catch (FileNotFoundException e){
            System.out.println("Файл не найден. Проверьте правильность имени файла.");
        }

    }
}
