import javax.sound.midi.*;
import java.awt.*;
import java.io.*;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.swing.*;
public class MiniMusicPlayer3 {
    JFrame frame = new JFrame("Music Player");
    MyDrawPanel ml;
    public static void main(String[] args) {
        MiniMusicPlayer3 player = new MiniMusicPlayer3();
        player.go();
    }

    public void setUpGui() {
        ml = new MyDrawPanel();
        frame.setContentPane(ml);
        frame.setBounds(30,30,300,300);
        frame.setVisible(true);
    }

    public void go() {
        setUpGui();
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addControllerEventListener(ml, new int[]{127});
            Sequence sequence = new Sequence(Sequence.PPQ,4);
            Track track = sequence.createTrack();
            int r =0;
            for(int i=0;i<60;i+=4)
            {
                r = (int)((Math.random()*50)+1);
                track.add(makeEvent(144,1,r,100,i));
                track.add(makeEvent(176,1,127,0,i));
                track.add(makeEvent(128,1,r,100,r+2));
            }
            sequencer.setSequence(sequence);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//close method

    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }//close method

    class MyDrawPanel extends JPanel implements ControllerEventListener {
        boolean msg = false;
        public void controlChange(ShortMessage event)
        {
            msg = true;
            repaint();
        }

        public void paintComponent(Graphics g) {
            if(msg) {
                Graphics2D g2d = (Graphics2D) g;
                int r = (int)(Math.random()*255);
                int gr = (int)(Math.random()*255);
                int b = (int)(Math.random()*255);

                g.setColor(new Color(r,gr,b));
                int ht = (int)((Math.random()*120)+10);
                int width = (int)((Math.random()*120)+10);
                int x = (int)((Math.random()*40)+10);
                int y = (int)((Math.random()*40)+10);
                g.fillRect(x, y, width, ht);
                msg = false;               
            } //close if
        }//close method
    }
}