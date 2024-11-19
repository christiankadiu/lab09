package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    // private static final String PATH = System.getProperty("user.home")
    // + File.separator
    // + Controller.class.getSimpleName() + ".txt";
    private static final String DEFAULT_FILE = "output.txt";

    private static final String HOME = System.getProperty("user.home");

    private File currentFile;

    /**
     * Constructor for the class Controller.
     * Initializes the current file to a default path in the user's home directory.
     */
    public Controller() {
        currentFile = new File(HOME + File.separator + DEFAULT_FILE);
    }

    /**
     * Sets the current file to the specified file.
     *
     * @param fileName the file to set as the current file
     */
    public void setCurrentFile(final File fileName) {
        currentFile = fileName;
    }

    /**
     * Returns the absolute path of the current file.
     *
     * @return the absolute path of the current file
     */
    public String getPath() {
        return currentFile.getAbsolutePath();
    }

    /**
     * Writes the specified string to the current file.
     *
     * @param string the text to save in the file
     * @throws IOException if an I/O error occurs during writing
     */
    public void writeFile(final String string) {
        try (PrintStream ps = new PrintStream(currentFile, StandardCharsets.UTF_8)) {
            ps.print(string);
        } catch (IOException e1) {
            e1.printStackTrace(); // NOPMD: allowed as this is just an exercise
        }
    }

}
