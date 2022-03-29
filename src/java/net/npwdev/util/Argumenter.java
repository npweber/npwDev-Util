package net.npwdev.util;

import java.util.HashMap;

//Argumenter: Intake protocol for "String[] args"

public class Argumenter {

    //Holder of Arguments
    private HashMap<String, String> arguments;

    //Intake external program defined parameters to set up the Argumenter
    public Argumenter(Grouper<String> parameters){
        //Validate Parameters
        if(parameters == null || !(parameters.size() > 0) || (parameters.getIfEqual("") != null)) { Printer.print("Parameters cannot be null."); return; }

        //Init Argument Holder
        this.arguments = new HashMap<String, String>(){{
            parameters.forEach(parameter -> put(parameter, ""));
        }};
    }

    //Intake arguments passed by main
    public boolean intake(String args[]){
        //Validate input
        if(args == null || !(args.length > 0)) { Printer.print("Arguments cannot be null."); return false; }
        if((args.length / 2) < arguments.size()) { Printer.print("Not enough arguments."); return false; }
        for(String term : args)
            if(term.startsWith("-") && !arguments.containsKey(term)) {
                Printer.print("Invalid parameter input.");
                return false;
            }

        //Sort through the args[] to pair the values to their parameters
        for(int i = 0; i < args.length; i++){
            //(If a parameter is found)
            if(arguments.containsKey(args[i])) {
                //Assign the next term, being the value, to the argumenter
                arguments.put(args[i], args[i + 1]);
            }
        }
        return true;
    }

    //Grab a value from an argument from extending the "put" method
    public String getValue(String parameter){
        //Check for validity and grab value
        if(this.arguments.containsKey(parameter)) {
            String value = this.arguments.get(parameter);
            if (!value.isEmpty())
                return value;
            else
                Printer.print("Parameter needs input.");
        } else Printer.print("That is not a valid parameter");
        return "NULL";
    }

    //Utility: Grabs a value in the array form it was given in
    public Grouper<String> getArrayValue(String parameter){
        //Grab literal value
        String value = this.getValue(parameter);
        //Null check and create a grouper that contains the array
        if(!value.equalsIgnoreCase("NULL"))
            return new Grouper<String>(){{ importFromArray(value.split(" ")); }};
        return null;
    }
}
