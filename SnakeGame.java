import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class SnakeGame extends JPanel {

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

    SnakeGame(int BoardWidth, int BoardHeight) { // Creating a panel for the window
        this.BoardWidth = BoardWidth;
        this.BoardHeight = BoardHeight;
        setPreferredSize(new Dimension(this.BoardWidth, this.BoardHeight));
        setBackground(Color.black);

        snakeHead = new Tile(5,5);

        food = new Tile(10, 10);

        random = new Random();
        placeFood();
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
}