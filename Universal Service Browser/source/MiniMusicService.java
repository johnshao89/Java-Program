import java.io.*;
import javax.swing.*;
import javax.sound.midi.*;
import java.awt.*;
import java.awt.event.*;

public class MiniMusicService {
    MyDrawPanel myPanel;

    public JPanel getGuiJPanel() {
        JPanel mainPanel = new JPanel();
        myPanel = new MyDrawPanel();
        JButton playItButton = new JButton("Play it");
        playItButton.addActionListener(new PlayItListener());
        mainPanel.add(MyDrawPanel);
        mainPanel.add(playItButton);
        return mainPanel;
    }//close the getGuiPanel method

    public class PlayItListener implements ActionListener {
        public void actionPerformed (ActionEvent ev) {
            try {
                Sequencer sequencer = MidiSystem.getSequencer();
                sequencer.open();
                sequencer.addControllerEventListener(myPanel, int[]{127});
                Sequence seq = sequencer.getSequence(Sequence.PPQ,4);
                Track track = seq.createTrack();
                for (int i=0;i<100; i+=4) {
                    int rNum = (int)((Math.random()*50)+1);
                    if(rNum <38) {
                        track.add(makeEvent(144,1,rNum,100,i)); // command 144 - 255 means note on, channel 1, 
                        track.add(makeEvent(176,1,127,0,i)); // note on, add 127 as data 1 to trigger the event
                        track.add(makeEvent(128,1,rNum,100,i+2)); //command 128-143 means note off
                    }
                }
                sequencer.setSequence(seq);
                sequencer.start();
                sequencer.setTempoInBPM(220);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//close the PlayItListener inner class

    private MidiEvent makeEvent(int command, int channel, int data1, int data2, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(command, channel, data1, data2);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return event;
    }//close the makeEvent method

    public class MyDrawPanel extends JPanel implements ControllerEventListener {
        boolean msg = false;
        public void controlChange(ShortMessage a) {
            msg = true;
            repaint();
        }

        public Dimension getPreferredSize() {
            return new Dimension(300,300);
        }

        public void paintComponent(Graphic g){
            if(msg) {
                Graphic2D g2 = (Graphic2D) g;
                int r = (int)(Math.random()*250);
                int gr = (int)(Math.random()*250);
                int b = (int)(Math.random()*250);
                g.setColor(new Color(r,gr,b));
                int ht = (int)((Math.random()*120)+10);
                int width = (int)((Math.random()*120)+10);
                int x = (int)((Math.random()*40)+10);
                int y = (int)((Math.random()*40)+10);
                g.fillRect(ht,width,x,y);
                msg = false;
            }
        }
    }//close the MyDrawPanel inner class
}
