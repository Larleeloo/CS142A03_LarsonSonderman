import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Giant extends Player{

    public int xBoardCoordsGiant;
    public int yBoardCoordsGiant;
    public Giant() throws IOException {
        super();
        this.setHP(30);
        this.setDiameter(2);
        File giantTexture1 = new File("Giant1.png");
        this.setBufferedImage(ImageIO.read(giantTexture1));

        this.xBoardCoordsGiant = 0;
        this.yBoardCoordsGiant = 0;
        this.xGraphicalCoords = 24 + (72 * xBoardCoordsGiant);
        this.yGraphicalCoords = 24 + (72 * yBoardCoordsGiant);
    }
    @Override
    public int getxBoardCoords(){
        return this.xBoardCoordsGiant;
    }
    @Override
    public int getyBoardCoords(){
        return this.yBoardCoordsGiant;
    }
    public void setxBoardCoordsGiant(int xBoardCoordsGiant){
        this.xBoardCoordsGiant = xBoardCoordsGiant;
    }
    public void setyBoardCoordsGiant(int yBoardCoordsGiant){
        this.yBoardCoordsGiant = yBoardCoordsGiant;
    }
    @Override
    public void setPos(int xGraphicalCoords, int yGraphicalCoords){
        this.xGraphicalCoords = xGraphicalCoords;
        this.yGraphicalCoords= yGraphicalCoords;

        this.xBoardCoordsGiant = (xGraphicalCoords - 24) / 72;
        this.yBoardCoordsGiant = (yGraphicalCoords - 24) / 72;
    }
    @Override
    public boolean checkOnBoardX(){
        if(this.incrementForward(1)[0] > 8 || this.incrementForward(1)[0] < 0){
            return false;
        }
        else {
            return true;
        }
    }
    @Override
    public boolean checkOnBoardY(){
        if(this.incrementForward(1)[1] > 8 || this.incrementForward(1)[1] < 0){
            return false;
        }
        else {
            return true;
        }
    }
    public int[] translateToGenericBoardCoords(){
        int[] giantArea = new int[this.getDiameter()^2];
        giantArea[0] = this.xBoardCoordsGiant;
        giantArea[1] = this.xBoardCoordsGiant + 1;
        giantArea[2] = this.yBoardCoordsGiant;
        giantArea[3] = this.yBoardCoordsGiant + 1;
        return giantArea;
    }

}
