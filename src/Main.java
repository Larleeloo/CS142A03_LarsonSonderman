
import javax.swing.*;
import java.io.IOException;

//todo
//Match goblin to renderedknight
//Set players 1 and 2 to be parts of the currentscene (in game class) but on separate knight/goblin lists
//auto robot turns and disable buttons
//implement attack detection
//implement Giant
public class Main {
    public static void main(String[] args) throws IOException {
        //test
        JFrame frame = new JFrame();
        JPanel heroesAndMonsters = new Game(1);

        frame.add(heroesAndMonsters);
        frame.setSize(1920,1080);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}




