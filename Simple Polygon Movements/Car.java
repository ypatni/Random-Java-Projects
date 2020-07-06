/**
 * Car
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Car extends JPanel {

    private final int WIDTH =800, HEIGHT= 800;
    private final int DELAY= 20;

    int [] xCar = {50, 50, 80, 120, 240, 300, 330, 330, 50};
    int [] yCar = {550, 500, 500, 470, 470, 470, 500, 550, 550};

    private Timer timer;
    private int x, y, moveX, moveY;

    public Car()
    {
        timer = new Timer(DELAY, new MoveListener());

        moveX=3;

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.black);
        timer.start();

    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        super.paintComponent(g);
        g.setColor(Color.green);
        g.fillPolygon(xCar, yCar, xCar.length);
    }
    private class MoveListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            for(int i = 0;i<xCar.length;i++)
            {
                xCar[i]+=moveX;

            }
            repaint();
        }
    }

}