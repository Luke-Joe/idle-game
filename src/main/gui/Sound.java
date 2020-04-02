package gui;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;

public class Sound {

    static AudioClip sound;
    static File oofFile;

    public static void playSound(String filename) {
        oofFile = new File("res/" + filename + ".wav");

        try {
            sound = Applet.newAudioClip(oofFile.toURL());
        } catch (Exception a) {
            a.printStackTrace();
        }

        sound.play();
    }

    public AudioClip getSound() {
        return sound;
    }
}
