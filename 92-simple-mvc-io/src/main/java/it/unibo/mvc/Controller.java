package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;


/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static final String PATH = System.getProperty("user.home")
    + File.separator
    + Controller.class.getSimpleName() + ".txt";

    File currentFile;

    public Controller(){
        currentFile = new File(PATH);
    }

    public void setCurrentFile(final File fileName){
        currentFile = fileName;
    }

    public String getPath(){
        return currentFile.getAbsolutePath();
    }

    public void writeFile(final String string){
        try (PrintStream ps = new PrintStream(PATH, StandardCharsets.UTF_8)) {
            ps.print(string);
        } catch (IOException e1) {
            e1.printStackTrace(); // NOPMD: allowed as this is just an exercise
        }
    }

}
