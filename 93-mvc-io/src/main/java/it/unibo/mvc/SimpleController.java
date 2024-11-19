package it.unibo.mvc;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private final List<String> lista;
    private String next;

    SimpleController() {
        lista = new LinkedList<>();
    }

    @Override
    public void setNextString(final String s) {
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
        return new LinkedList<>(lista);
    }

    @Override
    public void printCurrentString() {
        if (next == null || next.isBlank()) {
            throw new IllegalStateException();
        }
        System.out.println(next); // NOPMD it is okay to use the console
    }

}
