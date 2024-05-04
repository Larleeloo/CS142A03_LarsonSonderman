import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class MovementPanel extends JPanel {

    private JButton nextFrameButton = new JButton("Next Frame");

    GameGraphics gameGraphics;

    public MovementPanel(Battlefield battlefield) throws IOException {
        this.gameGraphics = new GameGraphics(battlefield);
        this.setPreferredSize(new Dimension(1920,1080));
        gameGraphics.setPreferredSize(new Dimension(1280,720));
        this.add(gameGraphics);

        //NextFrameListener nextFrameListener = new NextFrameListener();
        MouseClickListener mouseClickListener = new MouseClickListener();
        do {
            addMouseListener(mouseClickListener);
        }while(mouseClickListener.mouseDown);
        //nextFrameButton.addActionListener(nextFrameListener);
        //nextFrameButton.addMouseListener(mouseClickListener);

        //this.add(nextFrameButton);

    }

    class NextFrameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gameGraphics.battlefield.broadswords[0].moveOne();
            gameGraphics.nextFrame();
        }
    }
    class MouseClickListener implements MouseListener {
        volatile public boolean mouseDown = false;
        @Override
        public void mouseClicked(MouseEvent e) {
            gameGraphics.battlefield.broadswords[0].moveOne();
            gameGraphics.nextFrame();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                mouseDown = true;
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }


}
