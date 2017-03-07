package CFT;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TCFT {
    public static void main(String[] args) {
        if (args.length == 4) {
            try {
                ProgramArgs programArgs = Parser.parseArgs(args);

                SortingType fileType = programArgs.getSortType();
                SortDirection sortingDirection = programArgs.getSortDirection();
                ArrayList<?> list;

                if (fileType == SortingType.INTEGER) {
                    ArrayList<Integer> listInt = FileWorking.readIntegers(programArgs.getInputFilePath());
                    list = Sorting.sort(listInt, SortDirection.getDirection(sortingDirection, new IntegerComparator()));
                } else {
                    ArrayList<String> lineList = FileWorking.readStrings(programArgs.getInputFilePath());
                    list = Sorting.sort(lineList, SortDirection.getDirection(sortingDirection, new StringComparator()));
                }

                FileWorking.writeToFile(list, programArgs.getOutputFilePath());
            } catch (FileNotFoundException ex) {
                System.out.println("Файл не найден. Проверьте правильность имени файла");
            }

        } else {
            System.out.printf("%s%n%s%n%s%n%s%n%s%n", "Неверное количество аргументов, проверьте вводимые аргументы",
                    "Первый аргумент - имя файла, в котором лежат данные", "Второй аргумент - имя файла, куда надо положить отсортированные данные",
                    "Третий аргумент - тип данных, находящихся в файле: \"-i\" - числовые данные, \"-s\" - текст",
                    "Четвертый аргумент - тип сортировки: \"-а\" - по вощрастанию, \"-d\" - по убыванию");
        }
    }
}