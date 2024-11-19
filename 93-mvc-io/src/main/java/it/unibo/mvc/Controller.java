package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    /**
     * sets the next string.
     * 
     * @param s the value of the string to set
     * @throws nullpointerexeption if the string is null
     */

    public void setNextString(String s);

    /**
     * returns the next string to print.
     * 
     * @return String
     */

    public String getNexString();

    /**
     * gets the history of strings printed.
     * 
     * @return List
     */

    public List<String> getHistory();

    /**
     * prints the current string.
     * 
     * @throws IllegalStateException if the string is unset
     */

    public void printCurrentString();

}
