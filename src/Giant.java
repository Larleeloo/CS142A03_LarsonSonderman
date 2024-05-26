import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Giant extends Player{
    public Giant() throws IOException {
        super();
        this.setHP(30);
        this.setDiameter(2);
        File giantTexture1 = new File("Goblin1.png");
        this.setBufferedImage(ImageIO.read(giantTexture1));
    }
}
