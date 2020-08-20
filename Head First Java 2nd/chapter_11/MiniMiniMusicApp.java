//package Head First Java 2nd.chapter_11;
import javax.sound.midi.*;
public class MiniMiniMusicApp {
    public static void main(String[] args)
    {
        MiniMiniMusicApp mini = new MiniMiniMusicApp();
        mini.go();
    }

    public void go() {
       try{
        Sequencer player = MidiSystem.getSequencer();
        player.open();
        Sequence sequence = new Sequence(Sequence.PPQ,4);
        Track track = sequence.createTrack();

        //Make some MidiEvenet for the track
        ShortMessage a = new ShortMessage();
        a.setMessage(144, 1, 40, 100);
        MidiEvent noteOn = new MidiEvent(a, 1);
        track.add(noteOn);
        ShortMessage b = new ShortMessage();
        b.setMessage(128, 1, 40, 100);
        MidiEvent noteOff = new MidiEvent(b, 16);
        track.add(noteOff);

        player.setSequence(sequence);
        player.start();
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
       }
    }
}