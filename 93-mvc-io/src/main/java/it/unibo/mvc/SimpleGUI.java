package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();

    /**
     * costructor.
     * @param cont
     */

    public SimpleGUI(final SimpleController cont) {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JTextField textField = new JTextField("TextField");
        final JTextArea textArea = new JTextArea();
        canvas.add(textField, BorderLayout.NORTH);
        canvas.add(textArea, BorderLayout.CENTER);
        final JButton print = new JButton("print");
        final JButton show = new JButton("show history");
        final JPanel newPanel = new JPanel();
        newPanel.setLayout(new FlowLayout(1));
        canvas.add(newPanel, BorderLayout.SOUTH);
        newPanel.add(print);
        newPanel.add(show);


        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                cont.setNextString(textField.getText());
                cont.printCurrentString();
            }
        });

        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                for (final String string : cont.getHistory()) {
                    textArea.append(string + "\n");
                }
            }
        });

        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void display() {
        /*
         * Make the frame one fifth the resolution of the screen. This very method is
         * enough for a single screen setup. In case of multiple monitors, the
         * primary is selected. In order to deal coherently with multimonitor
         * setups, other facilities exist (see the Java documentation about this
         * issue). It is MUCH better than manually specify the size of a window
         * in pixel: it takes into account the current resolution.
         */
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.pack();
        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setLocationByPlatform(true);
        /*
         * OK, ready to push the frame onscreen
         */
        frame.setVisible(true);
    }

    /**
     * main.
     * @param args
     */
    public static void main(final String... args) {
        new SimpleGUI(new SimpleController()).display();
    }

}
