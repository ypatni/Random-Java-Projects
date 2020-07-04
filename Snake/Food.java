public class Food {

    private Snake snake = new Snake();
    private int appleX; 
    private int appleY; 
    
    
    private final int FOODPOS = 20;
    
    public void createFood() {

        int location = (int) (Math.random() * FOODPOS);
        appleX = ((location * Board.getScreenSize()));
    
        location = (int) (Math.random() * FOODPOS);
        appleY = ((location * Board.getScreenSize()));
    
        if ((appleX == snake.getSnakeX(0)) && (appleY == snake.getSnakeY(0))) {
            createFood();
        }
    }
    
    public int getappleX() {
    
        return appleX;
    }
    
    public int getappleY() {
        return appleY;
    }
    }