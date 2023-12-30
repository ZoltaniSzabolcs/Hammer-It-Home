package game;

import java.awt.*;
import java.util.Random;

public class GameControl implements Runnable{
    private GameModel gameModel;
    private GameView gameView;
    private Thread gameThread;
    private Random random;
    private boolean movePlatform;
    private final int FPS = 60;
    public GameControl(GameModel gameModel, GameView gameView){
        this.gameModel = gameModel;
        this.gameView = gameView;
        this.random = new Random();
        this.movePlatform = false;
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run(){
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        while(gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1){
                update();
                gameView.repaint();
                delta--;
                drawCount++;

            }
            if(timer >= 1000000000){
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
    private void update(){

    }
}
