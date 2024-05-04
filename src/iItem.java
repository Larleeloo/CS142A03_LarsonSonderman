public interface iItem {
    int data = 0;
    Player owner = null;
    int locationx = 0;
    int locationy = 0;
    String[] effects = new String[25];

    public int getData();
    public int getLocationx();
    public int getLocationy();
    public Player getOwner();
    String getEffects(int index);
    public int setData(int dataIn);
    public int setLocationx(int locationIn);
    public int setLocationy(int locationIn);
    public Player setOwner(Player playerIn);
    String setEffects(int index, String effectIn);
}
