import javax.swing.*; // For creating a window

public class App {
    public static void main(String[] args) throws Exception {
        
        int BoardWidth = 600;
        int BoardHeight = BoardWidth;

        // Create a new window
        JFrame frame = new JFrame("Snake");
  
        frame.setSize(BoardWidth, BoardHeight);
        frame.setLocationRelativeTo(null); // Set the default location of the window to the middle
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close when user click on the close button
        frame.setVisible(true);

        SnakeGame snakeGame = new SnakeGame(BoardWidth, BoardHeight);
        frame.add(snakeGame);   
        frame.pack(); //Does not include the title of the window included in the size
        snakeGame.requestFocus(); // Just the snake game listen to the key press
    }
}