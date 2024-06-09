import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;


public class Goblin extends Monster{
    public Goblin() throws IOException {
        super("Goblin");
        this.setRole(4);
        this.setName("Goblin");
        setBufferedImage(getBufferedImage());
    }
    @Override
    public BufferedImage getBufferedImage() throws IOException {
        BufferedImage goblinSprite;
        InputStream is2 = Goblin.class.getResourceAsStream("/Resources/Goblin1.png");
        if (is2 == null) {
            throw new IOException("Resource not found: /Resources/Goblin1.png");
        }
        goblinSprite = ImageIO.read(is2);
        return goblinSprite;
    }
}