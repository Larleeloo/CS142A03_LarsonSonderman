
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

//todo
// *1) universal hit boxes (for objects, players, etc)
// *1a) figure out why giant isn't able to move the full length of the board
// 1b) make a collision checker for all entities
// *2) hp UI system, update on movement info, damage dealt, etc. attack delay on giant
// *3) define all coordinates on UI
// 4) 2 more classes
// 5) class select screen
// *6) auto robot turns and disable buttons
// 6a) Use WASD to move and Space to attack
// 6b) include Giant scalable AI
// 7) clean up encapsulation
// 7a) clean up UI
// 8) resizeable gameboard
// 9) load multiple scenes and beyond
public class Main {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("CardLayout Example");
        frame.setSize(1920, 1080);
        frame.setLayout(new BorderLayout()); // Use BorderLayout for proper layout management
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        StartScreen cardPanel = new StartScreen();
        frame.add(cardPanel, BorderLayout.CENTER); // Add CardPanel to the center of the frame

        frame.setVisible(true);
    }
}





