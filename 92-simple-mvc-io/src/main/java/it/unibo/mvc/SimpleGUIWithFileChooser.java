package it.unibo.mvc;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame();
    private static final int PROPORTION = 5;

    SimpleGUIWithFileChooser(final Controller cont) {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JTextArea textArea = new JTextArea();
        canvas.add(textArea, BorderLayout.CENTER);
        final JButton button = new JButton("save");
        canvas.add(button, BorderLayout.SOUTH);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                cont.writeFile(textArea.getText());
            }
        });
        final JPanel secondPanel = new JPanel();
        secondPanel.setLayout(new BoxLayout(secondPanel, BoxLayout.X_AXIS));
        final JTextField textField = new JTextField(cont.getPath());
        final JButton browseButton = new JButton("Browse");
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser chooser = new JFileChooser();
                chooser.setSelectedFile(cont.getCurrentFile());
                final int res = chooser.showSaveDialog(frame);
                if (res == JFileChooser.APPROVE_OPTION) {
                    cont.setCurrentFile(chooser.getSelectedFile());
                    textField.setText(chooser.getSelectedFile().getPath());
                } else if (res != JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(chooser, "error");
                }
            }
        });
        secondPanel.add(textField);
        secondPanel.add(browseButton);
        canvas.add(secondPanel, BorderLayout.NORTH);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.pack();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * main.
     * 
     * @param args
     */
    public static void main(final String... args) {
        new SimpleGUIWithFileChooser(new Controller()).display();
    }

}
