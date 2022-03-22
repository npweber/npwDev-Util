package tech.npwd.roots;

import java.io.*;

//ReaderStreamer: Reader that accepts InputStreams instead of files

public class ReaderStreamer extends Reader {

    //Use given InputStream to power Reader's BufferedReader
    public ReaderStreamer(InputStream stream){
        this.reader = new BufferedReader(new InputStreamReader(stream));
    }

    //Add Accessibility for the ReaderGrouper subtype
    public Grouper<String> getReaderGrouper(){
        Grouper<String> readerGrouper = new Grouper<>();
        while(this.isValid())
            readerGrouper.add(this.read());
        return readerGrouper;
    }
}
