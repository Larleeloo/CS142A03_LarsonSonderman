import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class RenderedBroadsword extends JComponent{
    private Broadsword broadsword = new Broadsword();
    private int x;
    private int y;
    private int diameter;
    private Color color;
    private File file;
    private BufferedImage bufferedImage;

    public RenderedBroadsword() throws IOException {
        x = broadsword.getLocationx();
        y = broadsword.getLocationy();
        color = null;
        file = new File("https://onedrive.live.com/embed?resid=A9CCCD1B44AAF6AF%2160304&authkey=%21ALrYU85aHk6lDHk&width=44&height=45");
     //   bufferedImage = ImageIO.read(file);
    }
    public RenderedBroadsword(int x, int y, int diameter, Color color) throws IOException {
        this.x = x;
        this.y = y;
        this.color = color;

        file = new File("https://onedrive.live.com/embed?resid=A9CCCD1B44AAF6AF%2160304&authkey=%21ALrYU85aHk6lDHk&width=44&height=45");
       // bufferedImage = ImageIO.read(file);
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
        this.broadsword.setLocationx(this.x + 1);
        this.x = broadsword.getLocationx();
    }



}
