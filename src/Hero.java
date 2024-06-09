import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Hero extends Player {
    BufferedImage attackArea;
    public Hero(String name) throws IOException {
        super();
        setName(name);
        setBoardPos(9,9);
        this.hp = 10; // Example health value
        this.xBoardCoords = xBoardCoords;
        this.yBoardCoords = yBoardCoords;
        this.xGraphicalCoords = (72 * xBoardCoords) + 12;
        this.yGraphicalCoords = (72 * yBoardCoords) + 12;
        this.diameter = 1; // Example diameter value
        this.alive = true;
        setmyDir(3);// Default direction
        this.file = new File("src/Resources/Knight1.png");
        InputStream is = getClass().getResourceAsStream("/Resources/Knight1.png");
        if (is == null) {
            throw new IOException("Resource not found: /Resources/Knight1.png");
        }
        bufferedImage = ImageIO.read(is);
    }
    public static BufferedImage getAttackArea() throws IOException {
        BufferedImage attackArea;
        InputStream is2 = Goblin.class.getResourceAsStream("/Resources/Friendly_Attack_Area.png");
        if (is2 == null) {
            throw new IOException("Resource not found: /Resources/Friendly_Attack_Area.png");
        }
        attackArea = ImageIO.read(is2);
        return attackArea;
    }

    public void setAttackArea(BufferedImage attackArea){
        this.attackArea = attackArea;
    }
}