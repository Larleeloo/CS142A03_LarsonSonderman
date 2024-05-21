import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


public class Goblin extends Player{
    public Goblin() throws IOException {
        super();
        File goblinTexture1 = new File("Goblin1.png");
        this.setBufferedImage(ImageIO.read(goblinTexture1));
    }
}