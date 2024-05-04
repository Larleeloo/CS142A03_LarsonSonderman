import java.io.IOException;

public class Battlefield extends WorldOfThings {
    public RenderedBroadsword[] broadswords = GenerateEntities.createBroadswords(63);

    public Battlefield(int data) throws IOException {
        super(data);
    }

/*    public void drawEmptyField(int sizeX, int sizeY){
        for(int i = 0; i < sizeY; i++){
            System.out.println();
            for(int j = 0; j < sizeX; j++){
                System.out.print("[_]");
            }
        }
    }*/
/*    public void drawFilledField(int sizeX, int sizeY, WorldOfThings world){
        for(int y = 0; y < sizeY; y++){
            System.out.println();
            for(int x = 0; x < sizeX; x++){
                if(!world.containsPlayerAtPos(x,y)) {
                    System.out.print("[_]");
                }
                else{
                    System.out.print("[O]");
                }
            }
        }
    }*/
}
