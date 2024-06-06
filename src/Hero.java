import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Hero extends Player {
    BufferedImage attackArea;
    File HeroAttackArea;
    public Hero(String name, int role, int xBoardCoords, int yBoardCoords) throws IOException {
        super();
        this.name = name;
        this.hp = 10; // Example health value
        this.xBoardCoords = xBoardCoords;
        this.yBoardCoords = yBoardCoords;
        this.xGraphicalCoords = (72 * xBoardCoords) + 12;
        this.yGraphicalCoords = (72 * yBoardCoords) + 12;
        this.diameter = 1; // Example diameter value
        this.alive = true;
        this.myDir = directions.NORTH; // Default direction
        this.file = new File("Knight1.png");
        this.bufferedImage = ImageIO.read(file);

        HeroAttackArea = new File("Friendly_Attack_Area.png");
        attackArea = ImageIO.read(HeroAttackArea);
    }
    public BufferedImage getAttackArea(){
        return this.attackArea;
    }

    public void setAttackArea(BufferedImage attackArea){
        this.attackArea = attackArea;
    }
}