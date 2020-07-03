/**
 * Stopwatch
 */
import java.awt.event.*;
import java.lang.Math.*;

import java.awt.*;
import javax.swing.*;

public class Stopwatch extends JPanel{
    private final int WIDTH =800, HEIGHT= 800;
    private final int DELAY= 1;
    private Timer timer;
    private int milliseconds = 0;
    private int seconds = 0;
    private int minutes = 0;
    private int tick = 0;
    private JButton b;
    private JButton c;
    private JLabel time;

    public Stopwatch()
    {
        timer = new Timer(DELAY, new TimeListener());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.white);
        b = new JButton("Start");
        c = new JButton("Stop");
        b.addActionListener(new ButtonListener());
        c.addActionListener(new ButtonListener());

        
         time = new JLabel("00:00:000");

        
        add(b);
        add(c);
        add(time);
    }
    public void paintComponent(Graphics g)
    {

        super.paintComponent(g);
    }

    private class ButtonListener implements ActionListener
    
    {
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource()==b)
            {
                timer.start();
            }
            else if(event.getSource()==c)
            {
                timer.stop();
            }

        }
    }



    private class TimeListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            tick++;
            minutes = tick/60000;
            seconds = (tick%60000)/1000;
            milliseconds = (tick%60000)%1000;

            repaint();
            time.setText(minutes + ":" + seconds+":"+milliseconds+":");

        }
    }



}



