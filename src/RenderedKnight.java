import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

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
        url = new URL("https://media.discordapp.net/attachments/1239441072862531617/1239441185114689598/Goblin1.png?ex=6642ef0e&is=66419d8e&hm=e4658a1fcb4eb8316978eeab205987145d550d274b26b8f93885fa896239e8ce&=&format=webp&quality=lossless&width=76&height=62");
        //https://drive.google.com/file/d/19koz86bnGgPiYCSSAiyGhD3RoEfYCgx3/view?usp=drive_link
        //file = new File("/Users/sonderman/Desktop/CS142A03_LarsonSonderman/src/Knight1.png");
        bufferedImage = ImageIO.read(url);
    }
    public RenderedKnight(int x, int y, int diameter, Color color) throws IOException {
        this.x = x;
        this.y = y;
        this.color = color;

        file = new File("/Users/sonderman/Desktop/CS142A03_LarsonSonderman/src/Knight1.png");
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
