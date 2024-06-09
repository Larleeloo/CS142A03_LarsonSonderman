import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Knight extends Hero{
    public Knight() throws IOException {
        super("Knight");
        this.setRole(1);
    }
}
