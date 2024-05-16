import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class RenderedGoblin {
    private Player goblin = new Player();
    private int x;
    private int y;
    private int diameter;
    private Color color;
    private File file;
    private URL url;
    private BufferedImage bufferedImage;

    public RenderedGoblin() throws IOException {
        x = goblin.getxGraphicalCoords();
        y = goblin.getxGraphicalCoords();
        color = null;
        ReadableByteChannel rbc = Channels.newChannel(new URL("https://dsm04pap002files.storage.live.com/y4meZUzt7R0YSV6UfL5khnAPUAKlNgLH1inbEGm6TuyAgg7Oz9byXF9Gr5blyIlyW6xPNEcR4XSc70jdF8OZCwPAdu8rp0LqCume87NTrd6gmFaYaaBMoQJzc0dm8TLo8E5Tf_GlRKdeN1u64S0VfWSj2W5lWRUWMIbKOYc4GQ-ZBSoRIXBEjCym2ExMkxarR32e1NK0QyUX_FDgLdh_lHbkPbJ2v9rcZP7HnheEgwkea8?encodeFailures=1&width=38&height=31").openStream());
        FileOutputStream fos = new FileOutputStream(".Goblin1.png");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        file = new File(".Goblin1.png");
        bufferedImage = ImageIO.read(file);
    }
    public RenderedGoblin(int x, int y, int diameter, Color color) throws IOException {
        this.x = x;
        this.y = y;
        this.color = color;

        ReadableByteChannel rbc = Channels.newChannel(new URL("https://dsm04pap002files.storage.live.com/y4meZUzt7R0YSV6UfL5khnAPUAKlNgLH1inbEGm6TuyAgg7Oz9byXF9Gr5blyIlyW6xPNEcR4XSc70jdF8OZCwPAdu8rp0LqCume87NTrd6gmFaYaaBMoQJzc0dm8TLo8E5Tf_GlRKdeN1u64S0VfWSj2W5lWRUWMIbKOYc4GQ-ZBSoRIXBEjCym2ExMkxarR32e1NK0QyUX_FDgLdh_lHbkPbJ2v9rcZP7HnheEgwkea8?encodeFailures=1&width=38&height=31").openStream());
        FileOutputStream fos = new FileOutputStream(".Goblin1.png");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        file = new File(".Goblin1.png");
        bufferedImage = ImageIO.read(file);
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int getDiameter(){
        return this.diameter;
    }
    public Color getColor(){
        return this.color;
    }
    public File getFile(){
        return this.file;
    }
    public BufferedImage getBufferedImage(){
        return this.bufferedImage;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setDiameter(int diameter){
        this.diameter = diameter;
    }
    public void setColor(Color color){
        this.color = color;
    }

    public void setFile(File file){
        this.file = file;
    }
    public void setBufferedImage(BufferedImage bufferedImage){
        this.bufferedImage = bufferedImage;
    }
    public void moveOne(){
        this.goblin.moveForward(1);
        this.x = goblin.getxGraphicalCoords();
        this.y = goblin.getyGraphicalCoords();

    }



}
