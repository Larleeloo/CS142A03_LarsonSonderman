public class Item implements iItem{
    int data;
    Player owner = null;
    int locationx;
    int locationy;
    String[] effects = new String[5];

    public Item(){
        this.data = 1;
        this.owner = null;
        this.locationx = 0;
        this.locationy = 0;
        this.effects[0] = "Melee";
    }

    public Item(int data, Player owner, int locationx, int locationy, String effect){
        this.data = data;
        this.owner = owner;
        this.locationx = locationx;
        this.locationy = locationy;
        this.effects[0] = effect;
    }
    public Item(int data, Player owner, int locationx, int locationy, String effect1, String effect2, String effect3, String effect4, String effect5){        this.data = data;
        this.owner = owner;
        this.locationx = locationx;
        this.locationy = locationy;
        this.effects[0] = effect1;
        this.effects[1] = effect2;
        this.effects[2] = effect3;
        this.effects[3] = effect4;
        this.effects[4] = effect5;
    }

    public int getData(){
        return this.data;
    }
    public int getLocationx(){
        return this.locationx;
    }
    public int getLocationy(){
        return this.locationy;
    }
    public Player getOwner(){
        return this.owner;
    }
    public String getEffects(int index){
        return this.effects[index];
    }
    public int setData(int dataIn){
        this.data = dataIn;
        return data;
    }
    public int setLocationx(int locationIn){
        this.locationx = locationIn;
        return locationx;
    }
    public int setLocationy(int locationIn){
        this.locationy = locationIn;
        return locationy;
    }
    public Player setOwner(Player playerIn){
        this.owner = playerIn;
        return owner;
    }
    public String setEffects(int index, String effectIn){
        this.effects[index] = effectIn;
        return effects[index];
    }
}
