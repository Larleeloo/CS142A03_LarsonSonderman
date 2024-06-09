import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class RenderedBackground {
    private Scene battlefield;
    private File file;
    private BufferedImage bufferedImage;
    public RenderedBackground(Scene battlefield) throws IOException {
        this.battlefield = battlefield;

        file = new File("Gameboard1.png");
        InputStream is = getClass().getResourceAsStream("/Resources/Gameboard1.png");
        if (is == null) {
            throw new IOException("Resource not found: /Resources/Gameboard1.png");
        }
        bufferedImage = ImageIO.read(is);
    }
    public File getFile(){
        return this.file;
    }
    public BufferedImage getBufferedImage(){
        return this.bufferedImage;
    }
    public void setFile(File file){
        this.file = file;
    }
    public void setBufferedImage(BufferedImage bufferedImage){
        this.bufferedImage = bufferedImage;
    }

}
