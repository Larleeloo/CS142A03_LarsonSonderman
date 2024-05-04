import java.io.File;
import java.io.IOException;

public class Game {
    Battlefield[] battlefields = new Battlefield[63];
    public Game(int landArea) throws IOException {
        battlefields = FillBattlefields.createBattlefields(landArea, 10);
    }
}
