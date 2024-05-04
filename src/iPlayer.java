public interface iPlayer {
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

    int direction = 1;

    public Player getNext();

    public Player getPrev();
    public int getInventorySize();
    public int getData();

    public int getHP();

    public int getMP();

    public Item getInentorySlot(int index);

    public int getStatIndex(int index);

    public Player setNext(Player playerIn);

    public Player setPrev(Player playerIn);
    public int setInventorySize(int size);
    public int setData(int dataIn);

    public int setHP(int HPIn);

    public int setMP(int MPIn);

    public Item setInentorySlot(int index, Item itemIn);

    public int setStatIndex(int index, int value);
    public int changeDir(char dir);
    public void moveForward(int steps);
    public int[] attack(Player player, Weapon weapon);

}
