import java.io.IOException;

public class FillBattlefields {
    public static Battlefield[] createBattlefields(int count, int size) throws IOException {
        Battlefield[] battlefields = new Battlefield[count];
        for (int i = 0; i < count; i++) {
            battlefields[i] = new Battlefield(size);
        }
        return battlefields;
    }
}
