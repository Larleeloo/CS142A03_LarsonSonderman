import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RenderedKnight {
    private Player knight = new Player();
    private int x;
    private int y;
    private int diameter;
    private Color color;
    private File file;
    private URL url;
    private BufferedImage bufferedImage;

    public RenderedKnight() throws IOException {
        x = knight.getxGraphicalCoords();
        y = knight.getxGraphicalCoords();
        color = null;

        ReadableByteChannel rbc = Channels.newChannel(new URL("https://dsm04pap002files.storage.live.com/y4mAH0d1ty_lrzlwGN_gSkKQq4TThmY8TkdIRPJxhCoS4JhRubHDVScAdS9POPthBCSjObaJj2GQghV3MQXer9JIz4arxqGqtwb6rdnIuHRrkjA9-g3mDjUXw07ItPDA2dtN7fdrrf8hUwhMOmQ_ruxFUmXrDd7YMx9kHC1XkCjgqUsuDg4FyiucU_Ota8B0ZZ69tR9kEbycogE52SSfFP65eBawjcFH8cqTdBSJgzxeS8?encodeFailures=1&width=44&height=45").openStream());
        FileOutputStream fos = new FileOutputStream(".Knight1.png");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        file = new File(".Knight1.png");
        bufferedImage = ImageIO.read(file);
    }
    public RenderedKnight(int x, int y, int diameter, Color color) throws IOException {
        this.x = x;
        this.y = y;
        this.color = color;

        ReadableByteChannel rbc = Channels.newChannel(new URL("https://dsm04pap002files.storage.live.com/y4mAH0d1ty_lrzlwGN_gSkKQq4TThmY8TkdIRPJxhCoS4JhRubHDVScAdS9POPthBCSjObaJj2GQghV3MQXer9JIz4arxqGqtwb6rdnIuHRrkjA9-g3mDjUXw07ItPDA2dtN7fdrrf8hUwhMOmQ_ruxFUmXrDd7YMx9kHC1XkCjgqUsuDg4FyiucU_Ota8B0ZZ69tR9kEbycogE52SSfFP65eBawjcFH8cqTdBSJgzxeS8?encodeFailures=1&width=44&height=45").openStream());
        FileOutputStream fos = new FileOutputStream(".Knight1.png");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        file = new File(".Knight1.png");
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
        this.knight.moveForward(1);
        this.x = knight.getxGraphicalCoords();
        this.y = knight.getyGraphicalCoords();
    }

    public BufferedImage setDirection(Player player, int direction){
        switch (direction){
            case 1:
                break;
            case 2:
                bufferedImage = rotateImageByDegrees(bufferedImage,90);
                break;
            case 3:
                bufferedImage = rotateImageByDegrees(bufferedImage,180);
                break;
            case 4:
                bufferedImage = rotateImageByDegrees(bufferedImage,270);
                break;
            default:
                System.out.println("Error in set render direction");
                break;
        }
        return bufferedImage;
    }
    public BufferedImage rotateImageByDegrees(BufferedImage img, double angle) {
        double rads = Math.toRadians(angle);
        double sin = Math.abs(Math.sin(rads)), cos = Math.abs(Math.cos(rads));
        int w = img.getWidth();
        int h = img.getHeight();
        int newWidth = (int) Math.floor(w * cos + h * sin);
        int newHeight = (int) Math.floor(h * cos + w * sin);

        BufferedImage rotated = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rotated.createGraphics();
        AffineTransform at = new AffineTransform();
        at.translate((newWidth - w) / 2, (newHeight - h) / 2);

        int x = w / 2;
        int y = h / 2;

        at.rotate(rads, x, y);
        g2d.setTransform(at);
        g2d.drawImage(img, 0, 0, null);
        g2d.dispose();

        return rotated;
    }


}
