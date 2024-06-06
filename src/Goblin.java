import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Goblin extends Monster{
    BufferedImage attackArea;
    File GoblinAttackArea;
    public Goblin(String name, int xBoardCoords, int yBoardCoords) throws IOException {
        super();
        this.setRole(1);
        this.xBoardCoords = xBoardCoords;
        this.yBoardCoords = yBoardCoords;
        this.setName(name);
        File goblinTexture1 = new File("Goblin1.png");
        this.setBufferedImage(ImageIO.read(goblinTexture1));

        GoblinAttackArea = new File("Enemy_Attack_Area.png");
        attackArea = ImageIO.read(GoblinAttackArea);
    }

    public BufferedImage getAttackArea(){
        return this.attackArea;
    }

    public void setAttackArea(BufferedImage attackArea){
        this.attackArea = attackArea;
    }
}