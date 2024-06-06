
import javax.swing.*;
import java.io.IOException;

//todo
// *1) universal hit boxes (for objects, players, etc)
// *1a) figure out why giant isn't able to move the full length of the board
// 1b) make a collision checker for all entities
// *2) hp UI system, update on movement info, damage dealt, etc. attack delay on giant
// *3) define all coordinates on UI
// 4) 2 more classes
// 5) class select screen
// 6) auto robot turns and disable buttons
// 6a) Use WASD to move and Space to attack
// 7) clean up encapsulation
// 8) resizeable gameboard
// 9) load multiple scenes and beyond
public class Main {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
        JPanel heroesAndMonsters = new Game(1);

        frame.add(heroesAndMonsters);
        frame.setSize(1920,1080);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}




