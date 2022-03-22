package tech.npwd.roots;

import java.io.IOException;

//Runner: Runs executables on demand

public class Runner {

    //Run Executable
    public static void runExec(String args){
        try {
            Runtime.getRuntime().exec(args);
        } catch (IOException e){ Printer.printError("Error in runtime. Troubleshooting is necessary.", e); }
    }
}
