import java.io.IOException;

public class Scene extends EntityControlManager {
    public RenderedBackground background = new RenderedBackground(this);
    public Scene(int data) throws IOException {
        super(data);
    }
    public void updateScene(){
        System.out.println("Scene Update");
    }
}
