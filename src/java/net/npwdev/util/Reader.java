package net.npwdev.util;

import java.io.*;

//Reader: Faster code for reading files

public class Reader {

    public BufferedReader reader;

    private boolean verbose;

    //Default Constructor
    public Reader(){}

    //Access Reader
    public Reader(File file) {
        //Set Verbose
        this.verbose = false;

        //Open the Buffered Reader
        try {
            this.reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e){
            Printer.printError("Error while setting file. Maybe a broken path? Otherwise troubleshoot.", e);
            e.printStackTrace();
        }
    }

    //Read
    public String read() {
        try {
            if(!verbose)
                Printer.print("Reading...");
            return reader.readLine();
        } catch (IOException e) {
            Printer.printError("Error while reading line. Troubleshooting is probably necessary.", e);
            e.printStackTrace();
        }
        return null;
    }

    //Close reading stream
    public void close(){
        try {
            reader.close();
            if(!verbose)
                Printer.print("Closed stream.");
        } catch (IOException e){
            Printer.printError("Error in closing stream. Troubleshooting is probably necessary.", e);
            e.printStackTrace();
        }
    }

    //Get status of data stream
    public boolean isValid(){
        try {
            return reader.ready();
        } catch (IOException e){
            Printer.printError("Error in checking stream status. Troubleshooting is probably necessary.", e);
            e.printStackTrace();
        }
        return false;
    }

    //Specifies SilentRunning
    public void verbose(boolean verbose){ this.verbose = verbose; }

    //Ease for finding working directory
    public static String workingDir(){ return System.getProperty("user.dir"); }

    //Ease for Constructor Parameter
    public static File fromString(String path){ return new File(path); }
}
