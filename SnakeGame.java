import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class SnakeGame extends JPanel implements ActionListener, KeyListener{

    private class Tile {
        int x; 
        int y;
        Tile(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    int BoardWidth;
    int BoardHeight;
    int tileSize = 25; // The panel contain 24 pixel

    // Food
    Tile food;

    // Snake
    Tile snakeHead;
    Random random;

    // Game logic
    Timer gameLoop;
    int velocityX;
    int velocityY;

    SnakeGame(int BoardWidth, int BoardHeight) { // Creating a panel for the window
        this.BoardWidth = BoardWidth;
        this.BoardHeight = BoardHeight;
        setPreferredSize(new Dimension(this.BoardWidth, this.BoardHeight));
        setBackground(Color.black);
        addKeyListener(this);
        setFocusable(true);

        snakeHead = new Tile(5,5);

        food = new Tile(10, 10);

        random = new Random();
        placeFood();

        velocityX = 0;
        velocityY = 0;
    
        gameLoop = new Timer(100, this);
        gameLoop.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        // Grid 
        for (int i = 0; i < BoardWidth/tileSize; i++) {
            g.drawLine(i*tileSize, 0, i*tileSize, BoardHeight); // Draw vertical line
            g.drawLine(0, i*tileSize, BoardWidth, i*tileSize); // Draw horizontal line
        }

        // Food
        g.setColor(Color.red);
        g.fillRect(food.x * tileSize, food.y * tileSize, tileSize, tileSize);


        // Snake
        g.setColor(Color.green);;
        g.fillRect(snakeHead.x * tileSize, snakeHead.y * tileSize, tileSize, tileSize);

    }

    public void placeFood() {
        food.x = random.nextInt(BoardWidth/tileSize); // 600/25 = 24 (pixel)
        food.y = random.nextInt(BoardHeight/tileSize);
    }

    public void move() {
        // Snake Head
        snakeHead.x += velocityX;
        snakeHead.y += velocityY;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            velocityX = 0;
            velocityY = -1;
        } 
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            velocityX = 0;
            velocityY = 1;
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            velocityX = -1;
            velocityY = 0;
        } 
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            velocityX = 1;
            velocityY = 0;
        }
    }

    // Dont need
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}