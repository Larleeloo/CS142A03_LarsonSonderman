import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class GameGraphics extends JComponent {
    Random rand = new Random();
    Scene currentScene;
    private Player player1, player2;
    private HealthBar healthBar1, healthBar2;

    public GameGraphics(Scene currentScene) throws IOException {
        this.currentScene = currentScene;
        this.player1 = currentScene.pHead;
        this.player2 = currentScene.pHead.next;
        this.healthBar1 = new HealthBar(player1);
        this.healthBar2 = new HealthBar(player2);
    }

    public void paintComponent(Graphics g){
        paintBackground(g, currentScene.background);
        if(currentScene.pHead != null && currentScene.pHead.next != null) {
            BufferedImage healthBarImage1 = healthBar1.getHealthBarImage();
            BufferedImage healthBarImage2 = healthBar2.getHealthBarImage();
            g.drawImage(healthBarImage1, 0, 900, null);
            g.drawImage(healthBarImage2, 0, 932, null);
            paintKnightAttackArea(g, (Knight) currentScene.pHead);
            paintGiantAttackArea(g, (Giant) currentScene.pHead.next);
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
    public void paintKnightAttackArea(Graphics g, Knight player1){
        g.drawImage(player1.getAttackArea(), player1.incrementForward(1)[0] * 72, player1.incrementForward(1)[1] * 72, null);
    }
    public void paintGiantAttackArea(Graphics g, Giant player2){
        g.drawImage(player2.getAttackArea(), player2.incrementForwardModGiant(1)[0] * 72, player2.incrementForwardModGiant(1)[1] * 72, null);
        g.drawImage(player2.getAttackArea(), player2.incrementForwardModGiant(1)[2] * 72, player2.incrementForwardModGiant(1)[3] * 72, null);
    }
    public void paintBackground(Graphics g, RenderedBackground background){
        g.drawImage(background.getBufferedImage(), 0, 0, null);
    }

}
