
import javax.swing.*;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Game HeroesAndMonsters = new Game(1);
        JFrame frame = new JFrame();
        JPanel panel = new MovementPanel(HeroesAndMonsters);

        frame.add(panel);
        frame.setSize(1920,1080);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);



    }
}
/*
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try {
            SimpleAudioPlayer.filePath = "C:\\Users\\Larle\\OneDrive\\Desktop\\SilentEchoes.wav";
            SimpleAudioPlayer audioPlayer =
                    new SimpleAudioPlayer();

            audioPlayer.play();
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("1. pause");
                System.out.println("2. resume");
                System.out.println("3. restart");
                System.out.println("4. stop");
                System.out.println("5. Jump to specific time");
                int c = sc.nextInt();
                audioPlayer.gotoChoice(c);
                if (c == 4)
                    break;
            }
            sc.close();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();

        }
    }
}*/




