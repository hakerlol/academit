package CFT;


import java.io.FileNotFoundException;

public enum SortingType {
    Numbers("-i"), Strings("-s");

    private String fileType;

    SortingType(String fileType){
        this.fileType = fileType;
    }

    public static void chooseSortingType(String inputFileName, Enum x, String direction) throws FileNotFoundException {

        if(x.equals(Numbers)){
            Sorting.sortInteger(FileWorking.readingInt(inputFileName), SortDirection(direction));
        }else if(x.equals(Strings)){
            Sorting.sortString(FileWorking.readingString(inputFileName), SortDirection(direction));
        }
        else {
            System.out.println("Недопустимая команда");
        }
    }
  public static int SortDirection(String s){
      if(s.equals("-a")){
          return 1;
      }else if(s.equals("-d")){
          return 0;
      }else {
          return -1;
      }
  }


}