import java.awt.event.*;
import java.lang.Math.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Driver {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Wheel Of Fortune");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Panel());
        frame.pack();
        frame.setVisible(true);

    }
}