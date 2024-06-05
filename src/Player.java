import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Player implements iPlayer{

    private int diameter;
    private Color color;
    private File file;
    private BufferedImage bufferedImage;

    String name;
    private enum role{
        GOBLIN,
        KNIGHT,
        GIANT
    };

    role pRole;
    Player next;
    Player prev;
    int data;
    int inventorySize = 0;
    Item[] inventory = new Item[63];
    Weapon weapon;
    int hp;
    int maxHP = 10;
    boolean alive;
    int mp;
    int[] stats = new int[10];
    int xGraphicalCoords;
    int yGraphicalCoords;
    int xBoardCoords;
    int yBoardCoords;
    public enum directions{
        NORTH,
        SOUTH,
        EAST,
        WEST
    };

    directions myDir = directions.NORTH;

    public Player() throws IOException {

        this.alive = true;
        this.color = null;
        file = new File("Knight1.png");
        bufferedImage = ImageIO.read(file);

        data = 0;
        name = "NONE";
        pRole = role.KNIGHT;
        inventorySize = 10;
        inventory[0] = new Weapon(0, this, this.xBoardCoords, this.yBoardCoords, "Melee");
        hp = 10;
        maxHP = 20;
        mp = 100;
        stats[0] = 7; //speed
        stats[1] = 7; //strength
        stats[2] = 7; //charisma
        stats[3] = 7; //wisdom
        stats[4] = 7; //intelligence
        stats[5] = 7; //dexterity
        stats[6] = 7; //constitution
        stats[7] = 7; //stamina
        stats[8] = 7; //confidence
        stats[9] = 7; //other

        xBoardCoords = 0;
        yBoardCoords = 0;
        xGraphicalCoords = (72 * xBoardCoords) + 12;
        yGraphicalCoords = (72 * yBoardCoords) + 12;
        diameter = 1;

        myDir = directions.NORTH;

    }
    public Player(String name,int role, int inventorySize, Item[] inventory, int hp, int mp,
                  int otherStat, int strength, int charisma, int wisdom, int intelligence, int dexterity, int constitution, int stamina, int confidence, int speed,
                  int xCoords, int yCoords,
                  int myDir, int data, int boardDiameter) throws IOException {

        this.diameter = boardDiameter;
        this.color = color;
        file = new File("Knight1.png");
        bufferedImage = ImageIO.read(file);

        this.name = name;
        this.pRole = roleTranslate(role);
        this.data = data;
        this.inventorySize = inventorySize;
        this.inventory = inventory;
        this.hp = hp;
        this.alive = this.hp > 0;
        this.mp = mp;
        this.stats[0] = otherStat;
        this.stats[1] = strength;
        this.stats[2] = charisma;
        this.stats[3] = wisdom;
        this.stats[4] = intelligence;
        this.stats[5] = dexterity;
        this.stats[6] = constitution;
        this.stats[7] = stamina;
        this.stats[8] = confidence;
        this.stats[9] = speed;


        xBoardCoords = 0;
        yBoardCoords = 0;
        this.xGraphicalCoords = (72 * xBoardCoords) + 12;
        this.yGraphicalCoords = (72 * yBoardCoords) + 12;
        this.myDir = directionTranslate(myDir);


    }
    public int getRole(){
        return roleTranslate(pRole);
    }
    public String getName(){
        return this.name;
    }

    public Player getNext(){
        return this.next;
    }
    public Player getPrev(){
        return this.prev;
    }
    public int getData(){
        return this.data;
    }
    public int getyGraphicalCoords(){return this.yGraphicalCoords;}
    public int getxGraphicalCoords(){return this.xGraphicalCoords;}
    public int getxBoardCoords(){
        return this.xBoardCoords;
    }
    public int getyBoardCoords(){
        return this.yBoardCoords;
    }
    public int getMyDir(){
        return directionTranslate(this.myDir);
    }

    public int getHP(){
        return this.hp;
    }
    public int getMaxHP(){
        return this.maxHP;
    }

    public int getMP(){
        return this.mp;
    }

    public int getInventorySize(){
        return this.inventorySize;
    }
    public Item getInentorySlot(int index){
        return this.inventory[index];
    }

    public int getStatIndex(int index){
        return this.stats[index];
    }
    public void setNull(){
        this.alive = false;
        this.color = null;
        file = null;
        bufferedImage = null;
        data = 0;
        name = null;
        pRole = null;
        inventorySize = 0;
        inventory = null;
        hp = 0;
        mp = 0;
        stats = null;
        xBoardCoords = 0;
        yBoardCoords = 0;
        xGraphicalCoords = 0;
        yGraphicalCoords = 0;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setRole(int intRole){
        this.pRole = roleTranslate(intRole);
    }
    public void setPos(int x, int y){
        this.xGraphicalCoords = x;
        this.yGraphicalCoords = y;
        this.xBoardCoords = (x - 12) / 72;
        this.yBoardCoords = (y - 12) / 72;
    }

    public void setBoardPos(int xBoardCoords, int yBoardCoords){
        this.xBoardCoords = xBoardCoords;
        this.yBoardCoords = yBoardCoords;
        this.xGraphicalCoords = (xBoardCoords * 72) + 12;
        this.yGraphicalCoords = (yBoardCoords * 72) + 12;
    }
    public Player setNext(Player playerIn){
        this.next = playerIn;
        return this.next;
    }

    public Player setPrev(Player playerIn){
        this.prev = playerIn;
        return this.prev;
    }
    public int setData(int dataIn){
        this.data = dataIn;
        return this.data;
    }

    public int setHP(int HPIn){
        this.hp = HPIn;
        return this.hp;
    }

    public void setMaxHP(int maxHP){
        this.maxHP = maxHP;
    }

    public int setMP(int MPIn){
        this.mp = MPIn;
        return this.mp;
    }

    public int setInventorySize(int sizeIn){
        this.inventorySize = sizeIn;
        return inventorySize;
    }
    public Item setInentorySlot(int index, Item itemIn){
        this.inventory[index] = itemIn;
        return inventory[index];
    }

    public int setStatIndex(int index, int value){
        this.stats[index] = value;
        return stats[index];
    }

    public void setmyDir(int myDir){
        this.myDir = directionTranslate(myDir);
    }

    public role roleTranslate(int intRole){
        switch (intRole){
            case 0:
                return role.KNIGHT;
            case 1:
                return role.GOBLIN;
            case 2:
                return role.GIANT;
            default:
                System.out.println("Error default role assigned");
                return role.KNIGHT;
        }

    }
    public int roleTranslate(role role){
        switch (role){
            case role.KNIGHT:
                return 0;
            case role.GOBLIN:
                return 1;
            case role.GIANT:
                return 2;
            default:
                return 0;
        }

    }
    public directions directionTranslate(int dirInt){
        switch (dirInt){
            case 1:
                return directions.NORTH;
            case 2:
                return directions.EAST;
            case 3:
                return directions.SOUTH;
            case 4:
                return directions.WEST;
            default:
                System.out.println("Error in direction translation");
                return directions.NORTH;
        }
    }
    public int directionTranslate(directions myDir){
        switch (myDir){
            case directions.NORTH:
                return 1;
            case directions.EAST:
                return 2;
            case directions.SOUTH:
                return 3;
            case directions.WEST:
                return 4;
            default:
                System.out.println("Error in direction translation");
                return 1;
        }
    }
    public boolean checkAlive(){
        if(this.hp <= 0){
            this.alive = false;
            this.bufferedImage = null;
        }
        return this.alive;
    }

    public void turnLeft(){
        switch (myDir){
            case directions.NORTH:
                this.bufferedImage = rotateImageByDegrees(this.getBufferedImage(), 0);
                myDir = directions.WEST;//was north now west
                break;
            case directions.SOUTH:
                this.bufferedImage = rotateImageByDegrees(this.getBufferedImage(), 180);
                myDir = directions.EAST;//was east now north
                break;
            case directions.EAST:
                this.bufferedImage = rotateImageByDegrees(this.getBufferedImage(), -90);
                myDir = directions.NORTH;//was south now east
                break;
            case directions.WEST:
                this.bufferedImage = rotateImageByDegrees(this.getBufferedImage(), 90);
                myDir = directions.SOUTH;//was west now south
                break;
        }
        pUpdateGraphicalDirections();
    }

    public void pUpdateGraphicalDirections(){
        switch (myDir){
            case directions.NORTH:
                this.bufferedImage = rotateImageByDegrees(this.getBufferedImage(), 0);
                break;
            case directions.SOUTH:
                this.bufferedImage = rotateImageByDegrees(this.getBufferedImage(), 180);
                break;
            case directions.EAST:
                this.bufferedImage = rotateImageByDegrees(this.getBufferedImage(), 90);
                break;
            case directions.WEST:
                this.bufferedImage = rotateImageByDegrees(this.getBufferedImage(), -90);
                break;
        }
    }
    public void turnRight(){
        switch (myDir){
            case directions.NORTH:
                this.bufferedImage = rotateImageByDegrees(this.getBufferedImage(), 0);
                myDir = directions.EAST;
                break;
            case directions.SOUTH:
                this.bufferedImage = rotateImageByDegrees(this.getBufferedImage(), 180);
                myDir = directions.WEST;
                break;
            case directions.EAST:
                this.bufferedImage = rotateImageByDegrees(this.getBufferedImage(), -90);
                myDir = directions.SOUTH;
                break;
            case directions.WEST:
                this.bufferedImage = rotateImageByDegrees(this.getBufferedImage(), 90);
                myDir = directions.NORTH;
                break;
        }
        pUpdateGraphicalDirections();
    }
    public void turnAround(){
        switch (myDir){
            case directions.NORTH:
                this.bufferedImage = rotateImageByDegrees(this.getBufferedImage(), 0);
                myDir = directions.SOUTH;
                break;
            case directions.SOUTH:
                this.bufferedImage = rotateImageByDegrees(this.getBufferedImage(), 180);
                myDir = directions.NORTH;
                break;
            case directions.EAST:
                this.bufferedImage = rotateImageByDegrees(this.getBufferedImage(), -90);
                myDir = directions.WEST;
                break;
            case directions.WEST:
                this.bufferedImage = rotateImageByDegrees(this.getBufferedImage(), 90);
                myDir = directions.EAST;
                break;
        }
        pUpdateGraphicalDirections();
    }

    public boolean checkForwardBounds(Player[] players) {
        boolean blocked = false;
        for (Player player : players) {
            if (player != this) {
                blocked = checkForwardBounds(player);
                if (blocked) {
                    System.out.println(player.name + " is in the way");
                    break;
                }
            }
        }
        return blocked;
    }

    public boolean checkForwardBounds(Player player) {
        boolean blocked = false;
        Rectangle forwardBounds = this.getForwardBounds();
        Rectangle playerBounds = player.getBounds();
        blocked = forwardBounds.intersects(playerBounds);
        return blocked;
    }

    public Rectangle getForwardBounds() {
        int[] xySteps = incrementForward(1);
        return new Rectangle(xySteps[0], xySteps[1], this.getDiameter(), this.getDiameter());
    }

    public Rectangle getBounds(){
        return new Rectangle(this.getxBoardCoords(), this.getyBoardCoords(), this.getDiameter(), this.getDiameter());
    }

    public boolean checkCollision(Player p1, Player p2){
        return p1.getForwardBounds().intersects(p2.getBounds());
    }
    public void moveForward(int steps, Player[] players) throws IOException {
        int graphicalSteps = steps * 72;
        if(!checkForwardBounds(players)) {
            switch (myDir) {
                case directions.NORTH:
                    if (checkOnBoardY()) {
                        this.yBoardCoords += steps;
                        this.yGraphicalCoords += graphicalSteps;
                    } else {
                        System.out.println("Error off board");
                    }
                    break;
                case directions.EAST:
                    if (checkOnBoardX()) {
                        this.xBoardCoords -= steps;
                        this.xGraphicalCoords -= graphicalSteps;
                    } else {
                        System.out.println("Error off board");
                    }
                    break;
                case directions.SOUTH:
                    if (checkOnBoardY()) {
                        this.yBoardCoords -= steps;
                        this.yGraphicalCoords -= graphicalSteps;
                    } else {
                        System.out.println("Error off board");
                    }
                    break;
                case directions.WEST:
                    if (checkOnBoardX()) {
                        this.xBoardCoords += steps;
                        this.xGraphicalCoords += graphicalSteps;
                    } else {
                        System.out.println("Error off board");
                    }
                    break;
                default:
                    System.out.println("Error in movement");
                    break;
            }
        }
        else{
            System.out.println("Path Blocked");
        }
    }
    public int[] incrementForward(int steps){
        int[] xySteps = new int[2];
        xySteps[0] = this.getxBoardCoords();
        xySteps[1] = this.getyBoardCoords();
        switch (myDir){
            case NORTH:
                xySteps[1] = this.yBoardCoords + steps;
                break;
            case EAST:
                xySteps[0] = this.xBoardCoords - steps;
                break;
            case SOUTH:
                xySteps[1] = this.yBoardCoords - steps;
                break;
            case WEST:
                xySteps[0] = this.xBoardCoords + steps;
                break;
            default:
                System.out.println("Error in incrementing steps");
                break;
        }
        return xySteps;
    }
    public boolean checkOnBoardX(){
        if(this.incrementForward(1)[0] > 9 || this.incrementForward(1)[0] < 0){
            return false;
        }
        else {
            return true;
        }
    }
    public boolean checkOnBoardY(){
        if(this.incrementForward(1)[1] > 9 || this.incrementForward(1)[1] < 0){
            return false;
        }
        else {
            return true;
        }
    }

    public void dealDamage(int damageDealt, Player damagedPlayer){
        damagedPlayer.hp -= damageDealt;
        System.out.println(damagedPlayer.name + ": " + damagedPlayer.hp + "hp");
        checkAlive();
    }

    public int[] attack(Player playerAttacked, Weapon weapon){
        System.out.println("Attack Attempt: ");
        if(this.incrementForward(1)[0] == playerAttacked.getxBoardCoords() && this.incrementForward(1)[1] == playerAttacked.getyBoardCoords()) {
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
                    fire_solution[2] = Math.round(weapon.damage * ((float) (playerAttacked.getStatIndex(8) - 7) / 4));
                    break;
                case 4:
                    fire_solution[2] = Math.round(weapon.damage * ((float) (playerAttacked.getStatIndex(8) - 7) / 3));
                    break;
                case 5:
                    fire_solution[2] = Math.round(weapon.damage * ((float) (playerAttacked.getStatIndex(8) - 7) / 2));
                    break;
                case 6:
                    fire_solution[2] = Math.round(weapon.damage * ((float) (playerAttacked.getStatIndex(8) - 7)));
                    break;
                case 7:
                    fire_solution[2] = weapon.damage + ((playerAttacked.getStatIndex(weapon.scalarIndex) - 7) / 4);
                    break;
                case 8:
                    fire_solution[2] = weapon.damage + ((playerAttacked.getStatIndex(weapon.scalarIndex) - 7) / 3);
                    break;
                case 9:
                    fire_solution[2] = weapon.damage + ((playerAttacked.getStatIndex(weapon.scalarIndex) - 7) / 2);
                    break;
                case 10:
                    fire_solution[2] = weapon.damage + playerAttacked.getStatIndex(weapon.scalarIndex) - 7;
                    break;
                case 11:
                    fire_solution[2] = weapon.damage + playerAttacked.getStatIndex(weapon.scalarIndex) - 7;
                    break;
                case 12:
                    fire_solution[2] = weapon.damage + playerAttacked.getStatIndex(weapon.scalarIndex) - 7;
                    break;
                case 13:
                    fire_solution[2] = weapon.damage + playerAttacked.getStatIndex(weapon.scalarIndex) - 7;
                    break;
                case 14:
                    fire_solution[2] = weapon.damage + 1 + playerAttacked.getStatIndex(weapon.scalarIndex) - 7;
                    break;
                case 15:
                    fire_solution[2] = weapon.damage + 1 + playerAttacked.getStatIndex(weapon.scalarIndex) - 7;
                    break;
                case 16:
                    fire_solution[2] = (weapon.damage + playerAttacked.getStatIndex(weapon.scalarIndex) - 7) * (1 + playerAttacked.getStatIndex(8) - 7);
                    if (fire_solution[2] <= 0) {
                        fire_solution[2] = 1;
                    }
                    break;
                case 17:
                    fire_solution[2] = (weapon.damage + playerAttacked.getStatIndex(weapon.scalarIndex) - 7) * (2 + playerAttacked.getStatIndex(8) - 7);
                    if (fire_solution[2] <= 1) {
                        fire_solution[2] = 2;
                    }
                    break;
                case 18:
                    fire_solution[2] = (weapon.damage + playerAttacked.getStatIndex(weapon.scalarIndex) - 7) * (3 + playerAttacked.getStatIndex(8) - 7);
                    if (fire_solution[2] <= 2) {
                        fire_solution[2] = 3;
                    }
                    break;
                case 19:
                    fire_solution[2] = (weapon.damage + playerAttacked.getStatIndex(weapon.scalarIndex) - 7) * (4 + playerAttacked.getStatIndex(8) - 7);
                    if (fire_solution[2] <= 3) {
                        fire_solution[2] = 4;
                    }
                    break;
                case 20:
                    fire_solution[2] = (weapon.damage + playerAttacked.getStatIndex(weapon.scalarIndex) - 7) * (4 + playerAttacked.getStatIndex(8) - 7) + 1;
                    if (fire_solution[2] <= 4) {
                        fire_solution[2] = 5;
                    }
                    System.out.println("Critical hit!");
                    break;
                case 21:
                    fire_solution[2] = (weapon.damage + playerAttacked.getStatIndex(weapon.scalarIndex) - 7) * (5 + playerAttacked.getStatIndex(8) - 7) + 2;
                    if (fire_solution[2] <= 5) {
                        fire_solution[2] = 6;
                    }
                    System.out.println("Over 20 roll!");
                    break;
            }
            System.out.println("Damage dealt: " + fire_solution[2]);
            this.dealDamage(fire_solution[2], playerAttacked);
            return fire_solution;
        }
        else{
            System.out.println("No playerAttacked at position to attack");
            return null;
        }
    }
    public int[] attack(Giant giantAttacked, Weapon weapon){
        System.out.println("Attack on Giant Attempt: ");
        if((this.incrementForward(1)[0] == giantAttacked.translateToGenericBoardCoords()[0] && this.incrementForward(1)[1] == giantAttacked.translateToGenericBoardCoords()[1]) //x1y1
                ||((this.incrementForward(1)[0] == giantAttacked.translateToGenericBoardCoords()[0]) && (this.incrementForward(1)[1] == giantAttacked.translateToGenericBoardCoords()[3])) //x1y2
                ||((this.incrementForward(1)[0] == giantAttacked.translateToGenericBoardCoords()[2]) && (this.incrementForward(1)[1] == giantAttacked.translateToGenericBoardCoords()[1])) //x2y1
                ||((this.incrementForward(1)[0] == giantAttacked.translateToGenericBoardCoords()[2]) && (this.incrementForward(1)[1] == giantAttacked.translateToGenericBoardCoords()[3]))) {//x2y2
            int[] fire_solution = new int[3];
            fire_solution[0] = giantAttacked.incrementForward(1)[0];//increments x N steps
            fire_solution[1] = giantAttacked.incrementForward(1)[1];//increments y N steps
            switch (giantAttacked.rollD20(giantAttacked, weapon.scalarIndex)) {
                case 1:
                    System.out.println("Critical miss!");
                    this.dealDamage(1, this);
                    fire_solution[2] = 0;
                    break;
                case 2:
                    fire_solution[2] = 0;
                    break;
                case 3:
                    fire_solution[2] = Math.round(weapon.damage * ((float) (giantAttacked.getStatIndex(8) - 7) / 4));
                    break;
                case 4:
                    fire_solution[2] = Math.round(weapon.damage * ((float) (giantAttacked.getStatIndex(8) - 7) / 3));
                    break;
                case 5:
                    fire_solution[2] = Math.round(weapon.damage * ((float) (giantAttacked.getStatIndex(8) - 7) / 2));
                    break;
                case 6:
                    fire_solution[2] = Math.round(weapon.damage * ((float) (giantAttacked.getStatIndex(8) - 7)));
                    break;
                case 7:
                    fire_solution[2] = weapon.damage + ((giantAttacked.getStatIndex(weapon.scalarIndex) - 7) / 4);
                    break;
                case 8:
                    fire_solution[2] = weapon.damage + ((giantAttacked.getStatIndex(weapon.scalarIndex) - 7) / 3);
                    break;
                case 9:
                    fire_solution[2] = weapon.damage + ((giantAttacked.getStatIndex(weapon.scalarIndex) - 7) / 2);
                    break;
                case 10:
                    fire_solution[2] = weapon.damage + giantAttacked.getStatIndex(weapon.scalarIndex) - 7;
                    break;
                case 11:
                    fire_solution[2] = weapon.damage + giantAttacked.getStatIndex(weapon.scalarIndex) - 7;
                    break;
                case 12:
                    fire_solution[2] = weapon.damage + giantAttacked.getStatIndex(weapon.scalarIndex) - 7;
                    break;
                case 13:
                    fire_solution[2] = weapon.damage + giantAttacked.getStatIndex(weapon.scalarIndex) - 7;
                    break;
                case 14:
                    fire_solution[2] = weapon.damage + 1 + giantAttacked.getStatIndex(weapon.scalarIndex) - 7;
                    break;
                case 15:
                    fire_solution[2] = weapon.damage + 1 + giantAttacked.getStatIndex(weapon.scalarIndex) - 7;
                    break;
                case 16:
                    fire_solution[2] = (weapon.damage + giantAttacked.getStatIndex(weapon.scalarIndex) - 7) * (1 + giantAttacked.getStatIndex(8) - 7);
                    if (fire_solution[2] <= 0) {
                        fire_solution[2] = 1;
                    }
                    break;
                case 17:
                    fire_solution[2] = (weapon.damage + giantAttacked.getStatIndex(weapon.scalarIndex) - 7) * (2 + giantAttacked.getStatIndex(8) - 7);
                    if (fire_solution[2] <= 1) {
                        fire_solution[2] = 2;
                    }
                    break;
                case 18:
                    fire_solution[2] = (weapon.damage + giantAttacked.getStatIndex(weapon.scalarIndex) - 7) * (3 + giantAttacked.getStatIndex(8) - 7);
                    if (fire_solution[2] <= 2) {
                        fire_solution[2] = 3;
                    }
                    break;
                case 19:
                    fire_solution[2] = (weapon.damage + giantAttacked.getStatIndex(weapon.scalarIndex) - 7) * (4 + giantAttacked.getStatIndex(8) - 7);
                    if (fire_solution[2] <= 3) {
                        fire_solution[2] = 4;
                    }
                    break;
                case 20:
                    fire_solution[2] = (weapon.damage + giantAttacked.getStatIndex(weapon.scalarIndex) - 7) * (4 + giantAttacked.getStatIndex(8) - 7) + 1;
                    if (fire_solution[2] <= 4) {
                        fire_solution[2] = 5;
                    }
                    System.out.println("Critical hit!");
                    break;
                case 21:
                    fire_solution[2] = (weapon.damage + giantAttacked.getStatIndex(weapon.scalarIndex) - 7) * (5 + giantAttacked.getStatIndex(8) - 7) + 2;
                    if (fire_solution[2] <= 5) {
                        fire_solution[2] = 6;
                    }
                    System.out.println("Over 20 roll!");
                    break;
            }
            System.out.println("Damage dealt: " + fire_solution[2]);
            this.dealDamage(fire_solution[2], giantAttacked);
            return fire_solution;
        }
        else{
            System.out.println("No playerAttacked at position to attack");
            return null;
        }
    }
    public int rollD20(Player player, int scalarStatIndex){
        //press enter
        return new Random().nextInt(1,20) + player.getStatIndex(scalarStatIndex) - 7;
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

    //not my code
    public static BufferedImage rotateImageByDegrees(BufferedImage img, double angle) {
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
