package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    private boolean leftHand, rightHand;
    private boolean leftHavePlatform, rightHavePlatform;
    public KeyHandler() {
        leftHand = false;
        rightHand = false;
        leftHavePlatform = false;
        rightHavePlatform = true;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            leftHand = true;

        }
        if (code == KeyEvent.VK_L) {
            rightHand = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            leftHand = false;
        }
        if (code == KeyEvent.VK_L) {
            rightHand = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public boolean isLeftHand() {
        return leftHand && leftHavePlatform;
    }

    public boolean isRightHand() {
        return rightHand && rightHavePlatform;
    }

    public boolean isLeftHavePlatform() {
        return leftHavePlatform;
    }

    public void setLeftHavePlatform(boolean leftHavePlatform) {
        this.leftHavePlatform = leftHavePlatform;
    }
}
