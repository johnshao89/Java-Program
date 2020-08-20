//package Head First Java 2nd.chapter_11;

import javax.sound.midi.*;
public class MusticTest1 {
    public void go() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            System.out.println("Successful got a sequencer.");
        } catch (MidiUnavailableException ex) {
            System.out.println("Bummer");
        }
    }

    public static void main(String[] args) {
        MusticTest1 mt = new MusticTest1();
        mt.go();
    }
}