package unsw.loopmania;


import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
public class BGM {
    
    public static void playBGM(String path) {
        try {
            File bgm = new File(path);
            if (bgm.exists()) {
                AudioInputStream ais = AudioSystem.getAudioInputStream(bgm);
                Clip clip = AudioSystem.getClip();
                clip.open(ais);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                JOptionPane.showMessageDialog(null, "press ok");
            } else {
                System.out.println("XXXXXXXXXXXXXXXXXXXXXXXX");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        //Media sound = new Media(new File("BGM/mu.WAV").toURI().toString());
        //MediaPlayer mp = new MediaPlayer(sound);
        //mp.play();
        //mp.setAutoPlay(true);
        playBGM("BGM/BGM1.mp3");
        /*File file = new File("BGM/BGM3.wav");
        AudioInputStream am;
        am = AudioSystem.getAudioInputStream(file);
        AudioFormat af = am.getFormat();
        SourceDataLine sd;
        //DataLine.Info dl = new DataLine.Info(SourceDataLine.class, af);
        sd = AudioSystem.getSourceDataLine(af);
        sd.open();
        sd.start();
        int sumByteRead = 0; 
        byte [] b = new byte[320];
        while (sumByteRead != -1) {
            sumByteRead = am.read(b, 0, b.length);
            if(sumByteRead >= 0 ) {
                sd.write(b, 0, b.length);
            }
        }
        sd.drain();
        sd.close();
        */
    }
}
