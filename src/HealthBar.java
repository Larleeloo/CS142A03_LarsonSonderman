import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HealthBar {
    private Player player;
    private BufferedImage background, heart, emptyHeart;
    private int heartX, heartY;

    public HealthBar(Player player) {
        this.player = player;
        try {
            background = ImageIO.read(new File("background.png"));
            heart = ImageIO.read(new File("heart.png"));
            emptyHeart = ImageIO.read(new File("empty_heart.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        heartX = heart.getWidth();
        heartY = heart.getHeight();
    }

    public BufferedImage getHealthBarImage(){
        int width = background.getWidth() * player.maxHP;
        int height = background.getHeight();
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        g2d.drawImage(background, 0 ,0, null);
        for(int i = 0; i < player.getMaxHP(); i++){
            g2d.drawImage(background, i * background.getWidth(), 0, null);
        }

        for(int i = 0; i < player.getHP(); i++){
            g2d.drawImage(heart, i * heartX, 0, null);
        }

        for(int i = player.getHP(); i < player.getMaxHP(); i++){
            g2d.drawImage(emptyHeart, i * heartX, 0, null);
        }
        g2d.dispose();
        return image;
    }
}
