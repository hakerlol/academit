package CFT;


public class ProgramArgs {
    private String inputFileName;
    private String outputFileName;
    private Enum sortType;
    private boolean sortDirection;

    public void setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    public void setSortType(Enum sortType) {
        this.sortType = sortType;
    }

    public void setSortDirection(boolean sortDirection) {
        this.sortDirection = sortDirection;
    }
}
