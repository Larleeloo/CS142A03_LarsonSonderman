
import javax.swing.*;
import java.io.IOException;

//todo
//gameGrahpics...
//doSomethingWithPrevInput render cases
//web file locations
//Battlefields update to scenes...
//Game...
//auto robot turns and disable buttons
//
public class Main {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
        JPanel panel = new Game(1);

        frame.add(panel);
        frame.setSize(1920,1080);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}




