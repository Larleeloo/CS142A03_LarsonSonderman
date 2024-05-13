import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RenderedBackground {
    private Scene battlefield;
    private File file;
    private BufferedImage bufferedImage;
    public RenderedBackground(Scene battlefield) throws IOException {
        this.battlefield = battlefield;
        file = new File("/Users/sonderman/Desktop/CS142A03_LarsonSonderman/src/Gameboard1.png");
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
