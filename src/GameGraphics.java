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
        paintPlayer1(g, currentScene.knight, currentScene.knight.getxGraphicalCoords(), currentScene.knight.getyGraphicalCoords());
        paintPlayer2(g, currentScene.goblin,  currentScene.goblin.getX(),  currentScene.goblin.getY());
    }

    public void nextFrame() {
        repaint();
    }
    public void paintPlayer1(Graphics g, RenderedKnight player1, int x, int y){
        g.drawImage(player1.getBufferedImage(), x, y, null);
    }
    public void paintPlayer2(Graphics g, RenderedGoblin player2, int x, int y){
        g.drawImage(player2.getBufferedImage(), x, y, null);
    }

    public void paintBroadswords(Graphics g, RenderedBroadsword[] broadswords){
        for (RenderedBroadsword broadsword : broadswords) {
            g.drawImage(broadsword.getBufferedImage(), broadsword.getX(), broadsword.getY(), null);
        }
    }

    public void paintBackground(Graphics g, RenderedBackground background){
        g.drawImage(background.getBufferedImage(), 0, 0, null);
    }

}
