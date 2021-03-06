package CFT;


public class Parser {
    public static ProgramArgs parseArgs(String[] args) {

        ProgramArgs programArgs = new ProgramArgs();
        programArgs.setInputFilePath(args[0]);
        programArgs.setOutputFilePath(args[1]);
        programArgs.setSortType(SortingType.sortType(args[2]));
        programArgs.setSortDirection(SortDirection.sortDirection(args[3]));

        return programArgs;
    }
}
