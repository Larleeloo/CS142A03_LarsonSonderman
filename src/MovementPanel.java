import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.TimerTask;

//todo
//merge Game and Movement panel (rename to just Game)
//create frames

public class MovementPanel extends JPanel {

    private JButton nextFrameButton = new JButton("Next Frame");
    MouseClickListener mouseClickListener = new MouseClickListener();

    GameGraphics gameGraphics;
    Game game;
    public MovementPanel(Game game) throws IOException {
        this.game = game;
        this.gameGraphics = new GameGraphics(game.battlefields[0]);
        this.setPreferredSize(new Dimension(1920,1080));
        gameGraphics.setPreferredSize(new Dimension(1280,720));
        this.add(gameGraphics);

        //NextFrameListener nextFrameListener = new NextFrameListener();
        addMouseListener(mouseClickListener);

        //nextFrameButton.addActionListener(nextFrameListener);
        //nextFrameButton.addMouseListener(mouseClickListener);

        //this.add(nextFrameButton);

    }
    public void gameFrames() throws InterruptedException {
        while (game.getGameOver()){
            gameGraphics.battlefield.broadswords[0].moveOne();
            Thread.sleep(1000);
            gameGraphics.nextFrame();
        }
    }

    class NextFrameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gameGraphics.battlefield.broadswords[0].moveOne();
            gameGraphics.nextFrame();
        }
    }
    class MouseClickListener implements MouseListener {
        public boolean mouseDown = false;
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Mouse Clicked " + mouseDown);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            mouseDown = true;
            System.out.println("Mouse Pressed " + mouseDown);
            mouseHeld(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            mouseDown = false;
            System.out.println("Mouse Released" + mouseDown);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            System.out.println("Mouse Entered" + mouseDown);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            System.out.println("Mouse Exit" + mouseDown);
        }

        public void mouseHeld(MouseEvent e){
            while(mouseDown){
                System.out.println("Loop");
                gameGraphics.battlefield.broadswords[0].moveOne();
                gameGraphics.nextFrame();
                if(!mouseDown){
                    break;
                }

            }

        }
    }


}
