public class Weapon extends Item{
    int damage;
    int range;
    int scalerIndex;
    public Weapon(){
        super();
        damage = 1;
        range = 1; // melee
        scalerIndex = 1; //strength
    }
}
