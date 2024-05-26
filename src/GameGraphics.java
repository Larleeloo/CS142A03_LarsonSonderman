import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class GameGraphics extends JComponent {
    Random rand = new Random();
    Scene currentScene;
    public GameGraphics(Scene currentScene) throws IOException {
        this.currentScene = currentScene;
    }

    public void paintComponent(Graphics g){
        paintBackground(g, currentScene.background);
        if(currentScene.pHead != null && currentScene.pHead.next != null) {
            paintPlayer1(g, currentScene.pHead, currentScene.pHead.getxGraphicalCoords(), currentScene.pHead.getyGraphicalCoords());
            paintPlayer2(g, currentScene.pHead.next, currentScene.pHead.next.getxGraphicalCoords(), currentScene.pHead.next.getyGraphicalCoords());
        }
    }

    public void nextFrame() {
        repaint();
    }
    public void paintPlayer1(Graphics g, Player player1, int xGraphicalCoords, int yGraphicalCoords){
        g.drawImage(player1.getBufferedImage(), xGraphicalCoords, yGraphicalCoords, null);
    }
    public void paintPlayer2(Graphics g, Player player2, int xGraphicalCoords, int yGraphicalCoords){
        g.drawImage(player2.getBufferedImage(), xGraphicalCoords, yGraphicalCoords, null);
    }

    public void paintBackground(Graphics g, RenderedBackground background){
        g.drawImage(background.getBufferedImage(), 0, 0, null);
    }

}
