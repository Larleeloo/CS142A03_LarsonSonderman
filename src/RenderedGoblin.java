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

        file = new File("Goblin1.png");
        bufferedImage = ImageIO.read(file);
    }
    public RenderedGoblin(int x, int y, int diameter, Color color) throws IOException {
        this.x = x;
        this.y = y;
        this.color = color;

        file = new File("Goblin1.png");
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
