
import java.awt.event.*;
import java.lang.Math.*;

import java.awt.*;
import javax.swing.*;

public class Driver13 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("StopWatch");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Stopwatch());
        frame.pack();
        frame.setVisible(true);
    }
}
