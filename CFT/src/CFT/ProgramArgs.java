package CFT;


public class ProgramArgs {
    private String inputFileName;
    private String outputFileName;
    private Enum sortType;
    private Enum sortDirection;

    public void setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    public String getInputFileName() {
        return inputFileName;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public Enum getSortType() {
        return sortType;
    }

    public Enum getSortDirection() {
        return sortDirection;
    }

    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    public void setSortType(Enum sortType) {
        this.sortType = sortType;
    }

    public void setSortDirection(Enum sortDirection) {
        this.sortDirection = sortDirection;
    }
}
