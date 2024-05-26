public class Weapon extends Item{
    int damage;
    int range;
    int scalarIndex;
    public Weapon(){
        super();
        damage = 1;
        range = 1; // melee
        scalarIndex = 1; //strength
    }
    public Weapon(int data, Player owner, int locationx, int locationy, String effect){
        super(data, owner, locationx, locationy, effect);
        damage = 1;
        range = 1; // melee
        scalarIndex = 1; //strength
    }
}
