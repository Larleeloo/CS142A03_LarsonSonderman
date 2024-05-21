import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Scene extends EntityControlManager {
    public RenderedKnight knight = new RenderedKnight();
    public RenderedGoblin goblin = new RenderedGoblin();
    public RenderedBackground background = new RenderedBackground(this);
    public Scene(int data) throws IOException {
        super(data);
    }

    public void updateScene(){
        System.out.println("Scene Update");
        //knight.setDirection(pHead, pHead.directionTranslate(pHead.getMyDir()));
        //knight.setBoardPos(pHead.getxBoardCoords(), pHead.getyBoardCoords());
        goblin.setX(pHead.next.getxGraphicalCoords());
        goblin.setY(pHead.next.getyGraphicalCoords());
    }
}
