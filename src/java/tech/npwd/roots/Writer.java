package tech.npwd.roots;

import java.io.*;

//Writer: Faster code for writing to files

public class Writer {

    private final File file;
    private BufferedWriter writer;

    private final boolean append;
	private int writeCount;

    //Access Writer
    public Writer(File file){
        this.file = file;
        this.append = true;
        openWriter();
    }

    //Access Writer & Control Appending to the File
    public Writer(File file, boolean append){
        this.file = file;
        this.append = append;
        openWriter();
    }

    //Open the BufferedWriter
    private void openWriter(){
		this.writeCount = 0;
        try {
            this.writer = new BufferedWriter(new FileWriter(this.file, this.append));
            Printer.print("Opened file.");
        } catch (IOException e){
            Printer.printError("Error in setting file. Maybe a broken path? Otherwise troubleshoot.", e);
            e.printStackTrace();
        }
    }

    //Write
    public void write(String line) {
        try {
            //Write a line break only if we are not on the first line of the file
			if((writeCount > 0 && !append) || append)
				writer.newLine();
				
            //Write line
            writer.write(line);

            //Send data
            writer.flush();
            Printer.print("Line Written.");
        } catch (IOException e) {
            Printer.printError("Error in writing to file. Troubleshooting is probably necessary.", e);
            e.printStackTrace();
        }
		
		writeCount++;
    }

    //Close writing stream
    public void close(){
        try {
            writer.close();
            Printer.print("Closed stream.");
        } catch (IOException e){
            Printer.printError("Error in writing to file. Troubleshooting is probably necessary.", e);
            e.printStackTrace();
        }
    }

    //Ease for Constructor Parameter
    public static File fromString(String string){ return new File(string); }

    //Ease for finding working directory
    public static String workingDir(){ return System.getProperty("user.dir"); }

    //Create the file, if not already created
    public void finalizeFile(){
        try {
            file.createNewFile();
            Printer.print("Created file '" + file.getName() + "' on disk.");
        } catch (IOException e) {
            Printer.printError("Error in creating file on disk. Troubleshooting is probably necessary.", e);
        }
    }
}