package tech.npwd.roots;

//Printer: Printing Utility

public class Printer {

    private static String prefix = "[ROOTS]: ";
    private final static String errorSuffix = "[ERROR]: ";
    private final String output;
    private final boolean enter;
    private final Exception error;

    //Printer Regular
    private Printer(String output){
        this.output = output;
        this.enter = true;
        this.error = null;
        print();
    }

    //Printer with carriage return option
    private Printer(String output, boolean noReturn){
        this.output = output;
        this.enter = !noReturn;
        this.error = null;
        print();
    }

    //Printer with error option
    private Printer(String output, boolean noReturn, Exception error){
        this.output = output;
        this.enter = !noReturn;
        this.error = error;
        print();
    }

    //Main Static Access to Printing
    public static void print(String output){ new Printer(output); }
    public static void printError(String output, Exception error){ new Printer(output, false, error); }
    public static void printNoReturn(String output){ new Printer(output, true); }

    //Print Viewable option: Logs a viewable msg in a script
    public static void printViewable(String output, int delayInterval){ new Printer(output); Sleeper.sleep(delayInterval); }

    //Print function
    private void print(){
        //Declare local prefix variable
        String messagePrefix = prefix;

        //Add Error Suffix in case of error
        if(error != null)
            messagePrefix = messagePrefix.concat(errorSuffix);

        //Combine prefix & output for printing
        String finalOutput = messagePrefix + this.output;

        //System print
        if(enter)
            System.out.println(finalOutput);
        else
            System.out.print(finalOutput);

        //Also print the stacktrace in case of an error
        if(error != null)
            error.printStackTrace();
    }

    //Set Custom Prefix
    public static void setCustomPrefix(String customPrefix){ prefix = prefix.replace("ROOTS", customPrefix); }
}
