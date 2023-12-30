package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    private boolean leftHand, rightHand;
    private GameControl gameControl;
    public KeyHandler(GameControl gameControl){
        this.gameControl = gameControl;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_A){
            leftHand = true;

        }
        if(code == KeyEvent.VK_L){
            rightHand = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
