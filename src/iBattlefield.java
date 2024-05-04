public interface iBattlefield {
    int data = 0;
    int playerCount = 0;
    int sizex = 0;
    int sizey = 0;
    Battlefield fieldNorth = null;
    Battlefield fieldSouth = null;
    Battlefield fieldEast = null;
    Battlefield fieldWest = null;
    Item[] itemsInSpace = new Item[sizex * sizey];
    public int getData();
    public int getPlayerCount();
    public int getSizex();
    public int getSizey();
    public Battlefield getFieldNorth();
    public Battlefield getFieldSouth();
    public Battlefield getFieldEast();
    public Battlefield getFieldWest();
    public Item[] getItemsInSpace();
    public int setData();
    public int setPlayerCount();
    public int setSizex();
    public int setSizey();
    public Battlefield setFieldNorth();
    public Battlefield setFieldSouth();
    public Battlefield setFieldEast();
    public Battlefield setFieldWest();
    public Item[] setItemsInSpace();
    public String[] summonItems(String item, int count, int x, int y);

}
