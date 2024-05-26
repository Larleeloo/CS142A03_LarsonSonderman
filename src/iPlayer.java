public interface iPlayer {
    String name = "NONE";
    int data = 0;
    Player next = null;
    Player prev = null;
    int inventorySize = 0;
    Item[] inventory = new Item[63];
    int hp = 0;
    int mp = 0;
    int[] stats = new int[10];
    int xCoords = 0;
    int yCoords = 0;
    int xBoardCoords = 0;
    int yBoardCoords = 0;
    public String getName();
    public Player getNext();
    int getxGraphicalCoords();
    int getyGraphicalCoords();
    int getxBoardCoords();
    int getyBoardCoords();
    public Player getPrev();
    public int getInventorySize();
    public int getData();
    public int getHP();
    public int getMP();
    public Item getInentorySlot(int index);
    public int getStatIndex(int index);
    public void setName(String name);
    public Player setNext(Player playerIn);
    public void setPos(int x, int y);
    public void setBoardPos(int x, int y);
    public Player setPrev(Player playerIn);
    public int setInventorySize(int size);
    public int setData(int dataIn);
    public int setHP(int HPIn);
    public int setMP(int MPIn);
    public Item setInentorySlot(int index, Item itemIn);
    public int setStatIndex(int index, int value);
    public void turnLeft();
    public void turnRight();
    public void turnAround();
    public void moveForward(int steps);
    public boolean checkOnBoardX();
    public boolean checkOnBoardY();
    public int[] attack(Player playerAttacked, Weapon weapon);


}
