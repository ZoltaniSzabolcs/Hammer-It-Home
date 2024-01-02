package game;

import game.leftHand.LeftHandControl;
import game.rightHand.RightHandControl;

public class GameControl implements Runnable{
    private LeftHandControl leftHandControl;
    private RightHandControl rightHandControl;
    private GameModel gameModel;
    private GameView gameView;
    private Thread gameThread;
    private KeyHandler keyHandler;
    private boolean movePlatform;
    private final int FPS = 60;
    public GameControl(GameModel gameModel, GameView gameView, LeftHandControl leftHandControl, RightHandControl rightHandControl, KeyHandler keyHandler){
        this.gameModel = gameModel;
        this.gameView = gameView;
        this.leftHandControl = leftHandControl;
        this.rightHandControl = rightHandControl;

        this.keyHandler = keyHandler;
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
//                System.out.println("FPS: " + drawCount + " Time: " + System.nanoTime());
                drawCount = 0;
                timer = 0;
            }
        }
    }
    private void update(){
        leftHandControl.run();
        rightHandControl.run();
    }
}
