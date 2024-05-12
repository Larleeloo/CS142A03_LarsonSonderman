import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class GameGraphics extends JComponent {
    Random rand = new Random();
    Circle[] cirlces = new Circle[63];
    Battlefield battlefield;
    //RenderedBroadsword[] broadswords = GenerateEntities.createBroadswords(63, 1280,720,50, 0,0,1,rand,null);

    public GameGraphics(Battlefield battlefield) throws IOException {
        this.battlefield = battlefield;
    }

    public void paintComponent(Graphics g){
        paintBroadswords(g, battlefield.broadswords);
    }

    public void nextFrame() {
        repaint();
    }

    public void doSomethingWithPrevInput(int input){
        switch (input){
            case 1:
                battlefield.broadswords[0].moveOne();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                break;
        }
    }

    public void paintBroadswords(Graphics g, RenderedBroadsword[] broadswords){
        for (RenderedBroadsword broadsword : broadswords) {
            g.drawImage(broadsword.getBufferedImage(), broadsword.getX(), broadsword.getY(), null);
        }
    }
}
