package CFT;


public class ProgramArgs {
    private String inputFilePath;
    private String outputFilePath;
    private SortingType sortType;
    private SortDirection sortDirection;

    public void setInputFilePath(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    public String getInputFilePath() {
        return inputFilePath;
    }

    public String getOutputFilePath() {
        return outputFilePath;
    }

    public SortingType getSortType() {
        return sortType;
    }

    public SortDirection getSortDirection() {
        return sortDirection;
    }

    public void setOutputFilePath(String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }

    public void setSortType(SortingType sortType) {
        this.sortType = sortType;
    }

    public void setSortDirection(SortDirection sortDirection) {
        this.sortDirection = sortDirection;
    }
}
