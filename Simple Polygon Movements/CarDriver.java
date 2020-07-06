import java.awt.*;
import javax.swing.*;

public class CarDriver {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Whippin My Tesla like its Some Whipped Cream");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Car());
        frame.pack();
        frame.setVisible(true);
    }
}