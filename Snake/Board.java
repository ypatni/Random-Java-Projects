import java.awt.event.*; 
import java.awt.*;
import javax.swing.*;


public class Board extends JPanel implements ActionListener {




private final static int SCREENWIDTH= 800;
private final static int SCREENHEIGHT= 780;


private final static int CELLSIZE = 20;



private final static int TOTALPIXELS = (SCREENWIDTH* SCREENHEIGHT)
        / (CELLSIZE * CELLSIZE);


private boolean running = true;


private Timer timer;

private static int speed = 56;

private Snake snake = new Snake();
private Food food = new Food();

public Board() {

    addKeyListener(new Keys());
    setBackground(Color.BLACK);
    setFocusable(true);

    setPreferredSize(new Dimension(SCREENWIDTH, SCREENHEIGHT));

    initializeGame();
}

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    draw(g);
}


void draw(Graphics g) {
    
    if (running == true) {
        g.setColor(Color.green);
        g.fillRect(food.getappleX(), food.getappleY(), CELLSIZE, CELLSIZE); // food

        
        for (int i = 0; i < snake.getJoints(); i++) {
            
            if (i == 0) {
                g.setColor(Color.RED);
                g.fillRect(snake.getSnakeX(i), snake.getSnakeY(i),
                        CELLSIZE, CELLSIZE);
            } else {
                g.fillRect(snake.getSnakeX(i), snake.getSnakeY(i),
                        CELLSIZE, CELLSIZE);
            }
        }

        Toolkit.getDefaultToolkit().sync();
    } else {
        gameOver(g);
    }
}

public void initializeGame() {
    snake.setJoints(3); 

    for (int i = 0; i < snake.getJoints(); i++) {
        snake.setSnakeX(SCREENWIDTH/ 2);
        snake.setSnakeY(SCREENHEIGHT/ 2);
    }
    snake.setMovingRight(true);

    food.createFood();

    timer = new Timer(speed, this);
    timer.start();
}

public void checkFoodCollisions() {

    if ((proximity(snake.getSnakeX(0), food.getappleX(), 20))
            && (proximity(snake.getSnakeY(0), food.getappleY(), 20))) {

        System.out.println("intersection");
        snake.setJoints(snake.getJoints() + 1);
        food.createFood();
    }
}

public void checkCollisions() {

    for (int i = snake.getJoints(); i > 0; i--) {

        if ((i > 5)
                && (snake.getSnakeX(0) == snake.getSnakeX(i) && (snake
                        .getSnakeY(0) == snake.getSnakeY(i)))) {
            running = false; //  game ends
        }
    }

    if (snake.getSnakeY(0) >= SCREENHEIGHT) {
        running = false;
    }

    if (snake.getSnakeY(0) < 0) {
        running = false;
    }

    if (snake.getSnakeX(0) >= SCREENWIDTH) {
        running = false;
    }

    if (snake.getSnakeX(0) < 0) {
        running = false;
    }

    if (!running) {
        timer.stop();
    }
}

public void gameOver(Graphics g) {

    String message = "Game Over";

    
    Font font = new Font("Arial", Font.PLAIN, 36);
    FontMetrics metrics = getFontMetrics(font);

    
    g.setColor(Color.WHITE);
    g.setFont(font);

    
    g.drawString(message, (SCREENWIDTH- metrics.stringWidth(message)) / 2,
            SCREENHEIGHT/ 2);

    System.out.println("Game Ended");

}


@Override
public void actionPerformed(ActionEvent e) {
    if (running == true) {

        checkFoodCollisions();
        checkCollisions();
        snake.move();

        System.out.println(snake.getSnakeX(0) + " " + snake.getSnakeY(0)
                + " " + food.getappleX() + ", " + food.getappleY());
    }
    
    repaint();
}

private class Keys extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if ((key == KeyEvent.VK_LEFT) && (!snake.isMovingRight())) {
            snake.setMovingLeft(true);
            snake.setMovingUp(false);
            snake.setMovingDown(false);
        }

        if ((key == KeyEvent.VK_RIGHT) && (!snake.isMovingLeft())) {
            snake.setMovingRight(true);
            snake.setMovingUp(false);
            snake.setMovingDown(false);
        }

        if ((key == KeyEvent.VK_UP) && (!snake.isMovingDown())) {
            snake.setMovingUp(true);
            snake.setMovingRight(false);
            snake.setMovingLeft(false);
        }

        if ((key == KeyEvent.VK_DOWN) && (!snake.isMovingUp())) {
            snake.setMovingDown(true);
            snake.setMovingRight(false);
            snake.setMovingLeft(false);
        }

        if ((key == KeyEvent.VK_ENTER) && (running == false)) {

            running = true;
            snake.setMovingDown(false);
            snake.setMovingRight(false);
            snake.setMovingLeft(false);
            snake.setMovingUp(false);

            initializeGame();
        }
    }
}

private boolean proximity(int a, int b, int closeness) {
    return Math.abs((long) a - b) <= closeness;
}

public static int getAllDots() {
    return TOTALPIXELS;
}

public static int getScreenSize() {
    return CELLSIZE;
}
}