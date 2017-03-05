package CFT;


public class ProgramArgs {
    private String inputFilePath;
    private String outputFilePath;
    private Enum sortType;
    private Enum sortDirection;

    public void setInputFilePath(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    public String getInputFilePath() {
        return inputFilePath;
    }

    public String getOutputFilePath() {
        return outputFilePath;
    }

    public Enum getSortType() {
        return sortType;
    }

    public Enum getSortDirection() {
        return sortDirection;
    }

    public void setOutputFilePath(String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }

    public void setSortType(Enum sortType) {
        this.sortType = sortType;
    }

    public void setSortDirection(Enum sortDirection) {
        this.sortDirection = sortDirection;
    }
}
