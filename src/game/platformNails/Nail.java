package game.platformNails;

import java.awt.*;
public class Nail {
    private Point position;
    private int currentImg;

    public Nail(Point position) {
        this.position = position;
        currentImg = 0;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public int getCurrentImg() {
        return currentImg;
    }

    public void setCurrentImg(int currentImg) {
        this.currentImg = currentImg;
    }
}