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
        ReadableByteChannel rbc = Channels.newChannel(new URL("https://dsm04pap002files.storage.live.com/y4m9av0EbF2MupxrjlP0kGYyN9vwoB_n6ow-uXh9At30UXmOTSKTA1LIIrg55ZCB3S0KyRqjZNFxtT9UR602IJq4GLBdsFCt9tJh82vUKgwNujLTqAXuubSvsfvh1ezi_752DGXWa8TNK-kDr78znpfxnygnKEpLn8565Ndq-5QBM9qGyUK-_WKe5A7kIDnqQXaTMsDzV_lwthOW-stZPMHw_qRFY4mm5hzcc78x4hCQrg?encodeFailures=1&width=720&height=720").openStream());
        FileOutputStream fos = new FileOutputStream(".Gameboard.png");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        file = new File(".Gameboard.png");
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
