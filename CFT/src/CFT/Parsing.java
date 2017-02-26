package CFT;

public class Parsing {


    public static ProgramArgs chooseSort(String[] args){
        if (args.length == 4){
            ProgramArgs programArgs = new ProgramArgs();
            programArgs.setInputFileName(args[0]);
            programArgs.setOutputFileName(args[1]);
            Enum type;
            switch (args[2]){
                case ("-i"):{
                    type = SortingType.INTEGER;
                }
                case ("-s"):{
                    type = SortingType.STRING;
                }default:{
                    throw new IllegalArgumentException();
                }

            }
            programArgs.setSortType(type);
            programArgs.setSortDirection(args[3]);

            return programArgs;
        }else {
            throw new IllegalArgumentException();
        }
    }

    public boolean sortDirection(String args){

    }
}
