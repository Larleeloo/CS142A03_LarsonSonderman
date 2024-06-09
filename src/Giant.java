import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Giant extends Monster{
    private boolean attackDelay;
    public Giant() throws IOException {
        super("Giant");
        this.setHP(30);
        this.setMaxHP(60);
        this.setDiameter(2);
        File giantTexture1 = new File("Giant1.png");
        this.setBufferedImage(ImageIO.read(giantTexture1));
        this.xBoardCoords = 0;
        this.yBoardCoords = 0;
        this.xGraphicalCoords = 24 + (72 * xBoardCoords);
        this.yGraphicalCoords = 24 + (72 * yBoardCoords);

        this.setRole(5);
        this.attackDelay = true;
        this.setDiameter(2);
    }
    @Override
    public void setPos(int xGraphicalCoords, int yGraphicalCoords){
        this.xGraphicalCoords = xGraphicalCoords;
        this.yGraphicalCoords= yGraphicalCoords;

        this.xBoardCoords = (xGraphicalCoords - 24) / 72;
        this.yBoardCoords = (yGraphicalCoords - 24) / 72;
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
        int[] giantArea = new int[4];
        giantArea[0] = this.xBoardCoords;
        giantArea[1] = this.yBoardCoords;
        giantArea[2] = this.xBoardCoords + 1;
        giantArea[3] = this.yBoardCoords + 1;
        return giantArea;
    }
    public Rectangle getForwardBounds2(){
        return new Rectangle(this.incrementForward(1)[2], this.incrementForward(1)[3], this.getDiameter(), this.getDiameter());
    }
    public boolean checkCollision2(Player p1, Giant p2){
        return p2.getForwardBounds2().intersects(p1.getBounds());
    }
    @Override
    public void moveForward(int steps, Player[] players) throws IOException {
        if(!checkForwardBounds(players)){
            super.moveForward(1, players);
        }
    }

    public int[] incrementForwardModGiant(int steps){
        int[] xySteps = new int[4];
        xySteps[0] = this.getxBoardCoords();
        xySteps[1] = this.getyBoardCoords();
        xySteps[2] = this.getxBoardCoords();
        xySteps[3] = this.getyBoardCoords();
        switch (myDir){
            case NORTH:
                xySteps[0] = this.xBoardCoords;
                xySteps[1] = this.yBoardCoords + steps + 1; //1 extra down (North)
                xySteps[2] = this.xBoardCoords + 1;
                xySteps[3] = xySteps[1];
                break;
            case EAST:
                xySteps[0] = this.xBoardCoords - steps;
                xySteps[1] = this.yBoardCoords;
                xySteps[2] = xySteps[0];
                xySteps[3] = this.yBoardCoords + 1;
                break;
            case SOUTH:
                xySteps[0] = this.xBoardCoords;
                xySteps[1] = this.yBoardCoords - steps;
                xySteps[2] = this.xBoardCoords + 1;
                xySteps[3] = xySteps[1];
                break;
            case WEST:
                xySteps[0] = this.xBoardCoords + steps + 1; //1 extra to the right (North)
                xySteps[1] = this.yBoardCoords;
                xySteps[2] = xySteps[0];
                xySteps[3] = this.yBoardCoords + 1;
                break;
            default:
                System.out.println("Error in incrementing steps");
                break;
        }
        return xySteps;
    }

    @Override
    public int[] incrementForward(int steps){
        int[] xySteps = new int[4];
        xySteps[0] = this.getxBoardCoords();
        xySteps[1] = this.getyBoardCoords();
        xySteps[2] = this.getxBoardCoords();
        xySteps[3] = this.getyBoardCoords();
        switch (myDir){
            case NORTH:
                xySteps[0] = this.xBoardCoords;
                xySteps[1] = this.yBoardCoords + steps;
                xySteps[2] = this.xBoardCoords + 1;
                xySteps[3] = xySteps[1];
                break;
            case EAST:
                xySteps[0] = this.xBoardCoords - steps;
                xySteps[1] = this.yBoardCoords;
                xySteps[2] = xySteps[0];
                xySteps[3] = this.yBoardCoords + 1;
                break;
            case SOUTH:
                xySteps[0] = this.xBoardCoords;
                xySteps[1] = this.yBoardCoords - steps;
                xySteps[2] = this.xBoardCoords + 1;
                xySteps[3] = xySteps[1];
                break;
            case WEST:
                xySteps[0] = this.xBoardCoords + steps;
                xySteps[1] = this.yBoardCoords;
                xySteps[2] = xySteps[0];
                xySteps[3] = this.yBoardCoords + 1;
                break;
            default:
                System.out.println("Error in incrementing steps");
                break;
        }
        return xySteps;
    }

    @Override
    public int[] attack(Player playerAttacked, Weapon weapon){
        System.out.println("Attack Attempt: ");
        if((this.incrementForwardModGiant(1)[0] == playerAttacked.getxBoardCoords() && this.incrementForwardModGiant(1)[1] == playerAttacked.getyBoardCoords())
                || (this.incrementForwardModGiant(1)[2] == playerAttacked.getxBoardCoords() && this.incrementForwardModGiant(1)[3] == playerAttacked.getyBoardCoords())
                && !this.attackDelay) {
            int[] fire_solution = new int[3];
            fire_solution[0] = playerAttacked.incrementForward(1)[0];//increments x N steps
            fire_solution[1] = playerAttacked.incrementForward(1)[1];//increments y N steps
            switch (playerAttacked.rollD20(playerAttacked, weapon.scalarIndex)) {
                case 1:
                    System.out.println("Critical miss!");
                    this.dealDamage(1, this);
                    fire_solution[2] = 0;
                    break;
                case 2:
                    fire_solution[2] = 0;
                    break;
                case 3:
                    fire_solution[2] = 3 * Math.round(weapon.damage * ((float) (playerAttacked.getStatIndex(8) - 7) / 4));
                    break;
                case 4:
                    fire_solution[2] = 3 * Math.round(weapon.damage * ((float) (playerAttacked.getStatIndex(8) - 7) / 3));
                    break;
                case 5:
                    fire_solution[2] = 3 * Math.round(weapon.damage * ((float) (playerAttacked.getStatIndex(8) - 7) / 2));
                    break;
                case 6:
                    fire_solution[2] = 3 * Math.round(weapon.damage * ((float) (playerAttacked.getStatIndex(8) - 7)));
                    break;
                case 7:
                    fire_solution[2] = 3 * (weapon.damage + ((playerAttacked.getStatIndex(weapon.scalarIndex) - 7) / 4));
                    break;
                case 8:
                    fire_solution[2] = 3 * (weapon.damage + ((playerAttacked.getStatIndex(weapon.scalarIndex) - 7) / 3));
                    break;
                case 9:
                    fire_solution[2] = 3 * (weapon.damage + ((playerAttacked.getStatIndex(weapon.scalarIndex) - 7) / 2));
                    break;
                case 10:
                    fire_solution[2] = 3 * (weapon.damage + playerAttacked.getStatIndex(weapon.scalarIndex) - 7);
                    break;
                case 11:
                    fire_solution[2] = 3 * (weapon.damage + playerAttacked.getStatIndex(weapon.scalarIndex) - 7);
                    break;
                case 12:
                    fire_solution[2] = 3 * (weapon.damage + playerAttacked.getStatIndex(weapon.scalarIndex) - 7);
                    break;
                case 13:
                    fire_solution[2] = 3 * (weapon.damage + playerAttacked.getStatIndex(weapon.scalarIndex) - 7);
                    break;
                case 14:
                    fire_solution[2] = 3 *  (weapon.damage + 1 + playerAttacked.getStatIndex(weapon.scalarIndex) - 7);
                    break;
                case 15:
                    fire_solution[2] = 3 * (weapon.damage + 1 + playerAttacked.getStatIndex(weapon.scalarIndex) - 7);
                    break;
                case 16:
                    fire_solution[2] = 3 * (weapon.damage + playerAttacked.getStatIndex(weapon.scalarIndex) - 7) * (1 + playerAttacked.getStatIndex(8) - 7);
                    if (fire_solution[2] <= 0) {
                        fire_solution[2] = 1;
                    }
                    break;
                case 17:
                    fire_solution[2] = 3 * (weapon.damage + playerAttacked.getStatIndex(weapon.scalarIndex) - 7) * (2 + playerAttacked.getStatIndex(8) - 7);
                    if (fire_solution[2] <= 1) {
                        fire_solution[2] = 2;
                    }
                    break;
                case 18:
                    fire_solution[2] = 3 * (weapon.damage + playerAttacked.getStatIndex(weapon.scalarIndex) - 7) * (3 + playerAttacked.getStatIndex(8) - 7);
                    if (fire_solution[2] <= 2) {
                        fire_solution[2] = 3;
                    }
                    break;
                case 19:
                    fire_solution[2] = 3 * (weapon.damage + playerAttacked.getStatIndex(weapon.scalarIndex) - 7) * (4 + playerAttacked.getStatIndex(8) - 7);
                    if (fire_solution[2] <= 3) {
                        fire_solution[2] = 4;
                    }
                    break;
                case 20:
                    fire_solution[2] = 3 * (weapon.damage + playerAttacked.getStatIndex(weapon.scalarIndex) - 7) * (4 + playerAttacked.getStatIndex(8) - 7) + 1;
                    if (fire_solution[2] <= 4) {
                        fire_solution[2] = 5;
                    }
                    System.out.println("Critical hit!");
                    break;
                case 21:
                    fire_solution[2] = 3 * (weapon.damage + playerAttacked.getStatIndex(weapon.scalarIndex) - 7) * (5 + playerAttacked.getStatIndex(8) - 7) + 2;
                    if (fire_solution[2] <= 5) {
                        fire_solution[2] = 6;
                    }
                    System.out.println("Over 20 roll!");
                    break;
            }
            System.out.println("Damage dealt: " + fire_solution[2]);
            this.dealDamage(fire_solution[2], playerAttacked);
            this.attackDelay = true;
            return fire_solution;
        }
        else{
            this.attackDelay = false;
            System.out.println("No playerAttacked at position to attack or delayed");
            return null;
        }
    }

}
