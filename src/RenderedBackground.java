import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
        bufferedImage = ImageIO.read(file);
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
