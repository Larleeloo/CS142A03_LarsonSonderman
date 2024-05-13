import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class GenerateEntities {

    public static RenderedBroadsword[] createBroadswords(int count) throws IOException {
        RenderedBroadsword[] broadswords = new RenderedBroadsword[count];
        for(int i = 0; i < count; i++){
            broadswords[i] = new RenderedBroadsword();
        }
        return broadswords;
    }
    public static RenderedBroadsword[] createBroadswords(int count, int xBounds, int yBounds, int diameterBounds, int xOrigin, int yOrigin, int diameterMin, Random rand, Color color) throws IOException {
        RenderedBroadsword[] broadswords = new RenderedBroadsword[count];
        for(int i = 0; i < count; i++){
            broadswords[i] = new RenderedBroadsword(rand.nextInt(0,xBounds), rand.nextInt(0,yBounds), rand.nextInt(0,diameterBounds), color);
        }
        return broadswords;
    }
    public static Scene[] createScenes(int count, int size) throws IOException {
        Scene[] scenes = new Scene[count];
        for (int i = 0; i < count; i++) {
            scenes[i] = new Scene(size);
        }
        return scenes;
    }
    public static Scene createScene(int size) throws IOException {
        Scene scene = new Scene(size);
        return scene;
    }
}
