package net.npwdev.util;

//Sleeper: Utility sleep command

public class Sleeper {

    public static void sleep(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e){ Printer.printError("Problem with Thread.sleep process. Troubleshooting is necessary.", e); }
    }
}
