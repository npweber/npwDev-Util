package tech.npwd.roots;

//ReaderGrouper: Specialized Reader that Reads a File into a Grouper<String>

import java.io.File;

public class ReaderGrouper extends Reader {

    //Sub-class constructor
    public ReaderGrouper(File file){
        super(file);
    }

    //Read Into Grouper
    public Grouper<String> readIntoGrouper(){
        return new Grouper<String>(){{
            //Loop through lines and add them to the grouper
            while(isValid())
                add(read());
        }};
    }

}
