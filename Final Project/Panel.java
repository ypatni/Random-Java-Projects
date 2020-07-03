import java.awt.event.*;
import java.lang.Math.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.*;
import javax.swing.*;


public class Panel extends JPanel {
    private final int WIDTH = 900;
    private final int HEIGHT = 900;
    private JButton spin, reset;
    private int tick = 0;
    private ArrayList<Color> colors = new ArrayList<>();
    private Random rand;
    private Timer timer;
    private Color color1, color2, color3, temp;
    private int rand1;
    private int prize;
    private int totalPrize = 0;
    private Board board;
    private String str = "Correct: ";
    private String wrongStr = "Wrong: ";
    private String newLine = "";
    private Color color;
    
    public Panel()
    {
        
        rand = new Random();
        board = new Board();
        board.init();
        
        

        colors.add(new Color(255, 0, 0));
        colors.add(new Color(0, 0, 255));
        colors.add(new Color(0, 255, 0));
        colors.add(new Color(0, 0, 0));
        colors.add(new Color(255,182,193));
        colors.add(new Color(255, 215, 0));

        color = Color.decode("#C5EFA1");
    
        spin = new JButton("Spin");
        spin.addActionListener(new ButtonListener());
        reset = new JButton("New Phrase");
        reset.addActionListener(new ResetListener());
        add(spin);
        add(reset);
        
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setBackground(color);
        timer = new Timer(300, new TimeListener());
    }
    public void paintComponent(Graphics g)
    {
        g.drawString("to get a new phrase, press ", 10, 10);
        g.drawString("the button and then press spin", 10, 20);
        Font f = new Font("sans serif", Font.PLAIN, 18);
        g.setColor(new Color(64,224,208));
        g.fillRect(100, 150, 700, 400);
        g.setColor(Color.black);
        g.fillRect(175, 570, 550, 60);
        if(tick >=1 )
        {
            g.setColor(Color.black);
            Font h = new Font("impact", Font.PLAIN, 50);
            
            Font i = new Font("times new roman", Font.PLAIN, 50);
            g.setFont(h);
            
            g.drawString(board.initialDisplay(), 250, 350);
            g.setFont(i);
            g.drawString("THEME: MOVIES", 270, 90);


        }

         rand1 = rand.nextInt(colors.size());
         color1 = colors.get(rand1);   
         temp = color1;

        g.setColor(color1);
        
        g.fillArc(20, WIDTH - 250, WIDTH - 40, 500, 0, 60);

        

        int rand2 = rand.nextInt(colors.size());
        while(rand2==rand1)
        {
            rand2 = rand.nextInt(colors.size());
        }

        color2 = colors.get(rand2);      
        g.setColor(color2);
        g.fillArc(20, WIDTH - 250, WIDTH - 40, 500, 60, 61);
        int rand3 = rand.nextInt(colors.size());
        while(rand3==rand2 || rand3==rand1)
        {
            rand3 = rand.nextInt(colors.size());
        }
        color3 = colors.get(rand3);      
        g.setColor(color3);
        g.fillArc(20, WIDTH - 250, WIDTH - 40, 500, 121, 122);
        if(tick ==1 )
        {

        }
        if(tick ==6)
        {
            timer.stop();
            tick = 0;
            System.out.println(color2);
            g.setColor(Color.black);
            Font h = new Font("impact", Font.PLAIN, 32);
            g.setFont(h);

            //g.drawString(board.initialDisplay(), 190, 300);
        


            if(colors.indexOf(color2) == 0 && board.checkIfPresent())
            {
                prize = 1000;
                totalPrize += prize;
                g.setFont(h);
                g.setColor(Color.yellow);
                g.drawString("You got $" + prize+ " last round!", 180, 600);
            } 
            else if(colors.indexOf(color2) == 1 && board.checkIfPresent())
            {
                prize = 500;
                totalPrize += prize;
                //g.drawString(board.initialDisplay(), 190, 300);
                g.setFont(h);
                g.setColor(Color.yellow);
                g.drawString("You got $" + prize+ " last round!", 180, 600);
            }
            else if(colors.indexOf(color2) == 2 && board.checkIfPresent())
            {
                prize = 300;
                totalPrize += prize;
               // g.drawing(board.initialDisplay(), 190, 300);
                g.setFont(h);
                g.setColor(Color.yellow);
                g.drawString("You got $" + prize+ " last round!", 180, 600);
            }
            else if(colors.indexOf(color2) == 3 && board.checkIfPresent())
            {
                prize = 0;
                totalPrize += prize;
                //g.drawString(board.initialDisplay(), 190, 300);
                g.setFont(h);
                g.setColor(Color.yellow);
                g.drawString("Bad Luck! You got $" + prize+ " last round!", 180, 600);
            }
            else if(colors.indexOf(color2) == 4 && board.checkIfPresent())
            {
                prize = 100;
                totalPrize += prize;
                //g.drawString(board.initialDisplay(), 190, 300);
                g.setFont(h);
                g.setColor(Color.yellow);
                g.drawString("You got $" + prize+ " last round!", 180, 600);
            }
            else if(colors.indexOf(color2) == 5 && board.checkIfPresent())
            {
                prize = 5000;
                totalPrize += prize;
               // g.drawString(board.initialDisplay(), 190, 300);
                g.setFont(h);
                g.setColor(Color.yellow);
                g.drawString("You got $" + prize+ " last round!", 180, 600);
            }
            else 
            {
                totalPrize = 0;
                //g.drawString(board.initialDisplay(), 190, 300);
                g.setFont(h);
                g.setColor(Color.yellow);
                g.drawString("you have no money from the last turn", 180, 600);
            }

            board.takeInput();
            
            if(board.checkIfPresent())
            {
                str = str + board.getEntry();
            }
            else 
            {
                wrongStr += board.getEntry();
            }
            //board.getGuesses(str);


            System.out.println(board.checkIfPresent());
            
            System.out.println(prize);
            System.out.println(totalPrize);

        }

        g.setColor(Color.black);
        g.setFont(f);
        g.drawString("Prize Money: $" + totalPrize,700, 50);
        if(board.checkifComplete())
        {
            g.drawString("You Win! You won a total of $" + totalPrize, 180, 600);
        }
        g.drawString(wrongStr ,20, 50);
        g.drawString(str ,20, 120);
        
    }
    public String getGuesses()
    {
        return str;
    }
    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int end = 80;
            if(e.getSource()==spin)
            {
                timer.start();
            }

            
        }
    }
    private class ResetListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            
            if(e.getSource()==reset)
            {
                
                board.reset();
            }

            
        }
    }
    private class TimeListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            tick ++;
            System.out.println(tick);
            repaint();

        }
    }
}