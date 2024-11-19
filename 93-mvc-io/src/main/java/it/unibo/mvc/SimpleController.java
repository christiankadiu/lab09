package it.unibo.mvc;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private List<String> lista;
    private String currentString;
    private String next;

    SimpleController() {
        lista = new LinkedList<String>();
    }

    @Override
    public void setNextString(String s) {
        Objects.requireNonNull(s);
        next = s;
        lista.add(s);
    }

    @Override
    public String getNexString() {
        return next;
    }

    @Override
    public List<String> getHistory() {
        return lista;
    }

    @Override
    public void printCurrentString() {
        try {
            System.out.println(currentString);
        } catch (IllegalStateException e) {
            e.getMessage().isBlank();
        }
    }

}
