import java.util.Random;

public class Player implements iPlayer{
    String name;
    private enum role{
        GOBLIN,
        KNIGHT
    };

    role pRole;
    Player next;
    Player prev;
    int data;
    int inventorySize = 0;
    Item[] inventory = new Item[63];
    int hp;
    int mp;
    int[] stats = new int[10];
    int xGraphicalCoords;
    int yGraphicalCoords;
    int xBoardCoords;
    int yBoardCoords;
    private enum directions{
        NORTH,
        SOUTH,
        EAST,
        WEST
    };

    directions myDir = directions.NORTH;

    public Player(){
        data = 0;
        name = "NONE";
        pRole = role.KNIGHT;
        inventorySize = 10;
        inventory[0] = new Item();
        hp = 100;
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

        myDir = directions.NORTH;

    }
    public Player(String name,int role, int inventorySize, Item[] inventory, int hp, int mp,
                  int otherStat, int strength, int charisma, int wisdom, int intelligence, int dexterity, int constitution, int stamina, int confidence, int speed,
                  int xCoords, int yCoords,
                  int myDir, int data){
        this.name = name;
        this.pRole = roleTranslate(role);
        this.data = data;
        this.inventorySize = inventorySize;
        this.inventory = inventory;
        this.hp = hp;
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
    public directions getMyDir(){
        return this.myDir;
    }

    public int getHP(){
        return this.hp;
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
        this.yBoardCoords = xBoardCoords;
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

    public role roleTranslate(int intRole){
        switch (intRole){
            case 0:
                return role.KNIGHT;
            case 1:
                return role.GOBLIN;
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
    public void turnLeft(){
        switch (myDir){
            case directions.NORTH:
                myDir = directions.WEST;//was north now west
                break;
            case directions.SOUTH:
                myDir = directions.EAST;//was east now north
                break;
            case directions.EAST:
                myDir = directions.NORTH;//was south now east
                break;
            case directions.WEST:
                myDir = directions.SOUTH;//was west now south
                break;
        }
    }
    public void turnRight(){
        switch (myDir){
            case directions.NORTH:
                myDir = directions.EAST;
                break;
            case directions.SOUTH:
                myDir = directions.WEST;
                break;
            case directions.EAST:
                myDir = directions.SOUTH;
                break;
            case directions.WEST:
                myDir = directions.NORTH;
                break;
        }
    }
    public void turnAround(){
        switch (myDir){
            case directions.NORTH:
                myDir = directions.SOUTH;
                break;
            case directions.SOUTH:
                myDir = directions.NORTH;
                break;
            case directions.EAST:
                myDir = directions.WEST;
                break;
            case directions.WEST:
                myDir = directions.EAST;
                break;
        }
    }

    public void moveForward(int steps){
        int graphicalSteps = steps * 72;
        switch (myDir){
            case directions.NORTH:
                if(checkOnBoardY()) {
                    this.yBoardCoords += steps;
                    this.yGraphicalCoords += graphicalSteps;
                }
                else{
                    System.out.println("Error off board");
                }
                break;
            case directions.EAST:
                if(checkOnBoardX()) {
                    this.xBoardCoords += steps;
                    this.xGraphicalCoords += graphicalSteps;
                }
                else{
                    System.out.println("Error off board");
                }
                break;
            case directions.SOUTH:
                if(checkOnBoardY()) {
                    this.yBoardCoords -= steps;
                    this.yGraphicalCoords -= graphicalSteps;
                }
                else{
                    System.out.println("Error off board");
                }
                break;
            case directions.WEST:
                if(checkOnBoardX()) {
                    this.xBoardCoords -= steps;
                    this.xGraphicalCoords -= graphicalSteps;
                }
                else{
                    System.out.println("Error off board");
                }
                break;
            default:
                System.out.println("Error in movement");
                break;
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
                xySteps[0] = this.xBoardCoords + steps;
                break;
            case SOUTH:
                xySteps[1] = this.yBoardCoords- steps;
                break;
            case WEST:
                xySteps[0] = this.xBoardCoords - steps;
                break;
            default:
                System.out.println("Error in movement");
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
    public int[] attack(Player player, Weapon weapon){
        int[] fire_solution = new int[3];
        fire_solution[0] = player.incrementForward(1)[0];//increments x N steps
        fire_solution[1] = player.incrementForward(1)[1];//increments y N steps
        switch (player.rollD20(player, weapon.scalerIndex)){
            case 0:
                System.out.println("Critical miss!");
                fire_solution[2] = -1;
                break;
            case 1:
                fire_solution[2] = 0;
                break;
            case 2:
                fire_solution[2] = Math.round(weapon.damage * ((float)(player.getStatIndex(8) - 7) / 4)) ;
                break;
            case 3:
                fire_solution[2] = Math.round(weapon.damage * ((float)(player.getStatIndex(8) - 7) / 3)) ;
                break;
            case 4:
                fire_solution[2] = Math.round(weapon.damage * ((float)(player.getStatIndex(8) - 7) / 2)) ;
                break;
            case 5:
                fire_solution[2] = Math.round(weapon.damage * ((float)(player.getStatIndex(8) - 7))) ;
                break;
            case 6:
                fire_solution[2] = weapon.damage + ((player.getStatIndex(weapon.scalerIndex) - 7) / 4);
                break;
            case 7:
                fire_solution[2] = weapon.damage + ((player.getStatIndex(weapon.scalerIndex) - 7) / 3);
                break;
            case 8:
                fire_solution[2] = weapon.damage + ((player.getStatIndex(weapon.scalerIndex) - 7) / 2);
                break;
            case 9:
                fire_solution[2] = weapon.damage + player.getStatIndex(weapon.scalerIndex) - 7;
                break;
            case 10:
                fire_solution[2] = weapon.damage + player.getStatIndex(weapon.scalerIndex) - 7;
                break;
            case 11:
                fire_solution[2] = weapon.damage + player.getStatIndex(weapon.scalerIndex) - 7;
                break;
            case 12:
                fire_solution[2] = weapon.damage + player.getStatIndex(weapon.scalerIndex) - 7;
                break;
            case 13:
                fire_solution[2] = weapon.damage + 1 + player.getStatIndex(weapon.scalerIndex) - 7;
                break;
            case 14:
                fire_solution[2] = weapon.damage + 1 + player.getStatIndex(weapon.scalerIndex) - 7;
                break;
            case 15:
                fire_solution[2] = (weapon.damage + player.getStatIndex(weapon.scalerIndex) - 7) * (1 + player.getStatIndex(8) - 7);
                if(fire_solution[2] <= 0){
                    fire_solution[2] = 1;
                }
                break;
            case 16:
                fire_solution[2] = (weapon.damage + player.getStatIndex(weapon.scalerIndex) - 7) * (2 + player.getStatIndex(8) - 7);
                if(fire_solution[2] <= 1){
                    fire_solution[2] = 2;
                }
                break;
            case 17:
                fire_solution[2] = (weapon.damage + player.getStatIndex(weapon.scalerIndex) - 7) * (3 + player.getStatIndex(8) - 7);
                if(fire_solution[2] <= 2){
                    fire_solution[2] = 3;
                }
                break;
            case 18:
                fire_solution[2] = (weapon.damage + player.getStatIndex(weapon.scalerIndex) - 7) * (4 + player.getStatIndex(8) - 7);
                if(fire_solution[2] <= 3){
                    fire_solution[2] = 4;
                }
                break;
            case 19:
                fire_solution[2] = (weapon.damage + player.getStatIndex(weapon.scalerIndex) - 7) * (4 + player.getStatIndex(8) - 7) + 1;
                if(fire_solution[2] <= 4){
                    fire_solution[2] = 5;
                }
                break;
            case 20:
                fire_solution[2] = (weapon.damage + player.getStatIndex(weapon.scalerIndex) - 7) * (5 + player.getStatIndex(8) - 7) + 2;
                if(fire_solution[2] <= 5){
                    fire_solution[2] = 6;
                }
                System.out.println("Critical hit!");
                break;
        }

        return fire_solution;
    }
    public int rollD20(Player player, int scalerStatIndex){
        //press enter
        return new Random().nextInt(0,20) + player.getStatIndex(scalerStatIndex) - 7;
    }
}
