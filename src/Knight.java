import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Knight extends Player{
    BufferedImage attackArea;
    File KnightAttackArea;
    public Knight() throws IOException {
        super();
        KnightAttackArea = new File("Friendly_Attack_Area.png");
        attackArea = ImageIO.read(KnightAttackArea);
    }
    public BufferedImage getAttackArea(){
        return this.attackArea;
    }

    public void setAttackArea(BufferedImage attackArea){
        this.attackArea = attackArea;
    }
}
