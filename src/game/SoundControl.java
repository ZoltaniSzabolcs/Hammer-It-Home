package game;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class SoundControl {
    private Random random;
    private Clip clip;
    private AudioInputStream audioInputStream[];
    public SoundControl(){
        random = new Random();
//        System.out.println("Hello");
        try {
            this.audioInputStream  = new AudioInputStream[25];
            for (int i = 1; i <= 25; i++) {
//                System.out.println(i);
                audioInputStream[i - 1] = AudioSystem.getAudioInputStream(new File("res/sound/hitSound (" + i +").wav"));
            }
        } catch (UnsupportedAudioFileException | IOException e) {
            System.out.println("IO error");
        }
    }
    public void playRandomHitSound(){
        try {
            int i = random.nextInt(1, audioInputStream.length - 1);
            String filename = ".//res//sound/hitSound (" + i +").wav";
            File file = new File(filename);
            audioInputStream[i] = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream[i]);
            clip.setFramePosition(0);
            clip.start();
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
            System.out.println("IO error in playing");
        }
    }
}
