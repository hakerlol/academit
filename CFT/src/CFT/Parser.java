package CFT;


public class Parser {
    public static ProgramArgs chooseSort(String[] args) {
        if (args.length == 4) {
            ProgramArgs programArgs = new ProgramArgs();
            programArgs.setInputFileName(args[0]);
            programArgs.setOutputFileName(args[1]);
            programArgs.setSortType(SortingType.sortType(args[2]));
            programArgs.setSortDirection(SortDirection.sortDirection(args[3]));

            return programArgs;
        } else {
            throw new IllegalArgumentException("Неверное количество аргументов");
        }
    }
}
