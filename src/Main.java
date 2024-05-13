
import javax.swing.*;
import java.io.IOException;

//todo
//web file locations
//auto robot turns and disable buttons
//implement attack detection
public class Main {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
        JPanel heroesAndMonsters = new Game(1);

        frame.add(heroesAndMonsters);
        frame.setSize(1920,1080);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}




