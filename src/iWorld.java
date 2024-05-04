public interface iWorld {
    Node head = null;
    int size = 0;
    Player pHead = null;
    int pSize = 0;
    Item[] worldInventory = new Item[63];
    int iSize = 0;
    Battlefield bHead = null;
    int bSize = 0;
    public void nInsert(int data);
    public Player pInsert();
    public Player pInsert(int inventorySize, Item[] inventory, int hp, int mp,
                        int otherStat, int strength, int charisma, int wisdom, int intelligence, int dexterity, int constitution, int stamina, int confidence, int speed,
                        int xCoords, int yCoords,
                        int direction);
    public void iInsert();
    public void iInsert(int data, Player owner, int locationx, int locationy, String effect);
    public void iInsert(int data, Player owner, int locationx, int locationy, String effect1, String effect2, String effect3, String effect4, String effect5);
    public void bInsert();
    public Player pTraverseForward(int index);
    public void pDelete(int index);
    public void changeStat(int pIndex, int statIndex, int statChange);
    public void printList();
    public void pUpdate();

    public void pPush(Player p);
    public void pSwap(int player1Index, int player2Index);
    public void sortByHighestStatX(int x);

    public void pPrintStats();

    public void pAddToInventory(int pIndex, int slot, Item item);

    public int pCountInventoryItems(Item item, int pIndex);

    public void pPrintInventory(int pIndex);

    public boolean containsPlayerAtPos(int x, int y);

}
