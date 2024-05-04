import java.awt.*;
import java.util.Random;

public class Player implements iPlayer{
    Player next;
    Player prev;
    int data;
    int inventorySize = 0;
    Item[] inventory = new Item[63];
    int hp;
    int mp;
    int[] stats = new int[10];
    int xCoords;
    int yCoords;
    int direction;

    public Player(){
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

        xCoords = 0;
        yCoords = 0;

        direction = 1;

    }
    public Player(int inventorySize, Item[] inventory, int hp, int mp,
                  int otherStat, int strength, int charisma, int wisdom, int intelligence, int dexterity, int constitution, int stamina, int confidence, int speed,
                  int xCoords, int yCoords,
                  int direction){
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

        this.xCoords = xCoords;
        this.yCoords = yCoords;

        this.direction = direction;


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
    public int getyCoords(){return this.yCoords;}
    public int getxCoords(){return this.xCoords;}
    public int getDirection(){return this.direction;}

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

    public void setPos(int x, int y){
        this.xCoords = x;
        this.yCoords = y;
    }
    public int changeDir(char dir){
        switch (dir) {
            case 'n':
                this.direction = 1;
                break;
            case 's':
                this.direction = 3;
                break;
            case 'e':
                this.direction = 2;
                break;
            case 'w':
                this.direction = 4;
                break;
            default:
                System.out.println("Error in direction change");
                break;
        }
        return this.direction;
    }

    public void moveForward(int steps){
        switch (direction){
            case 1:
                this.yCoords += steps;
                break;
            case 2:
                this.xCoords += steps;
                break;
            case 3:
                this.yCoords -= steps;
                break;
            case 4:
                this.xCoords -= steps;
                break;
            default:
                System.out.println("Error in movement");
                break;
        }
    }
    public int[] incrementForward(int steps){
        int[] xySteps = new int[2];
        xySteps[0] = this.getxCoords();
        xySteps[1] = this.getyCoords();
        switch (direction){
            case 1:
                xySteps[1] = this.yCoords + steps;
                break;
            case 2:
                xySteps[0] = this.xCoords + steps;
                break;
            case 3:
                xySteps[1] = this.yCoords - steps;
                break;
            case 4:
                xySteps[0] = this.xCoords - steps;
                break;
            default:
                System.out.println("Error in movement");
                break;
        }
        return xySteps;
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
