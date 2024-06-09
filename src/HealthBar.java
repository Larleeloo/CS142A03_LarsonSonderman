import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class HealthBar {
    private Player player;
    private BufferedImage background, heart, emptyHeart;
    private int heartX, heartY;

    public HealthBar(Player player) {
        this.player = player;
        try {
            InputStream is = getClass().getResourceAsStream("/Resources/background.png");
            if (is == null) {
                throw new IOException("Resource not found: /Resources/background.png");
            }
            background = ImageIO.read(is);
            InputStream is2 = getClass().getResourceAsStream("/Resources/heart.png");
            if (is2 == null) {
                throw new IOException("Resource not found: /Resources/heart.png");
            }
            heart = ImageIO.read(is2);
            InputStream is3 = getClass().getResourceAsStream("/Resources/empty_heart.png");
            if (is3 == null) {
                throw new IOException("Resource not found: /Resources/empty_heart.png");
            }
            emptyHeart = ImageIO.read(is3);
        } catch (IOException e) {
            e.printStackTrace();
        }
        heartX = heart.getWidth();
        heartY = heart.getHeight();
    }

    public BufferedImage getHealthBarImage(){
        int width = background.getWidth() * player.maxHP;
        int height = background.getHeight();
        BufferedImage image = new BufferedImage(width*4,height*4,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        g2d.drawImage(background, 0 ,0, null);
        for(int i = 0; i < player.getMaxHP(); i++){
            g2d.drawImage(background, i * background.getWidth()*2, 0,64,64, null);
        }

        for(int i = 0; i < player.getHP(); i++){
            g2d.drawImage(heart, i * heartX * 2, 0,64,64, null);
        }

        for(int i = player.getHP(); i < player.getMaxHP(); i++){
            g2d.drawImage(emptyHeart, i * heartX * 2, 0,64,64, null);
        }
        g2d.dispose();
        return image;
    }
}
