//package Head First Java 2nd.chapter_11;
import javax.sound.midi.*;
public class MiniMusicCmdLine {
    public static void main(String[] args) {
        MiniMusicCmdLine mini = new MiniMusicCmdLine();
        if(args.length<2)
        {
            System.out.println("Do not forget the instrument and note args");
        }
        else{
            int instrument = Integer.parseInt(args[0]);
            int note = Integer.parseInt(args[1]);
            mini.play(instrument,note);
        }
    }

    public void play(int instrument, int note) {
        try{
        Sequencer player = MidiSystem.getSequencer();
        player.open();

        Sequence sequence = new Sequence(Sequence.PPQ,4);
        Track track = sequence.createTrack();

        MidiEvent event = null;

        ShortMessage first = new ShortMessage();
        first.setMessage(192, 1, instrument, note);
        MidiEvent changeInstrument = new MidiEvent(first, 1);
        track.add(changeInstrument);

        ShortMessage second = new ShortMessage();
        second.setMessage(144, 1, instrument, 0);
        MidiEvent noteOn = new MidiEvent(second, 1);
        track.add(noteOn);

        ShortMessage third = new ShortMessage();
        third.setMessage(128, 1, note, 100);
        MidiEvent noteOff = new MidiEvent(third, 16);
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