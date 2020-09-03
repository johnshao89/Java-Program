//package BeatBox

import javax.swing.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.*;
import javax.sound.midi.*;
import java.util.*;

public class BeatBox {
    JFrame frame;
    JPanel mainPanel;
    ArrayList<JCheckBox>checkBoxList;
    Sequencer sequencer;
    Sequence sequence;
    Track track;
    String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare",
        "Crash Cymbal","Hand Clap","High Tom","Hi Bongo","Maracas","Whistle","Low Conga","Cowbell","Vibraslap",
        "Low-mid Tom","High Agogo","Open Hi Conga"};

    int[] instrument = {34,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};

    public static void main(String[] args) {
        BeatBox beat = new BeatBox();
        beat.buildGui();
    }//close the main method

    public void buildGui() {
        frame = new JFrame("Beat Box Porject");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        checkBoxList = new ArrayList<JCheckBox>();

        Box buttonBox = new Box(BoxLayout.Y_AXIS);
        JButton start = new JButton("start");
        start.addActionListener(new MyStartListener());
        buttonBox.add(start);

        JButton stop = new JButton("stop");
        stop.addActionListener(new MyStopListener());
        buttonBox.add(stop);

        JButton upTemp = new JButton("Up Tempo");
        upTemp.addActionListener(new MyUpTempListener());
        buttonBox.add(upTemp);

        JButton downTemp = new JButton("Down Tempo");
        downTemp.addActionListener(new MyDownTempListener());
        buttonBox.add(downTemp);

        JButton serilizeIt = new JButton("Save");
        serilizeIt.addActionListener(new MySaveListener());
        buttonBox.add(serilizeIt);

        JButton restore = new JButton("Restore");
        restore.addActionListener(new MyRestoreListener());
        buttonBox.add(restore);

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for(String name: instrumentNames)
            nameBox.add(new JLabel(name));
        background.add(BorderLayout.EAST,buttonBox);
        background.add(BorderLayout.WEST,nameBox);
        frame.getContentPane().add(background);
        GridLayout grid = new GridLayout(16,16);
        mainPanel = new JPanel(grid);
        for(int i=0;i<256;i++)
        {
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkBoxList.add(c);
            mainPanel.add(c);
        }

        background.add(BorderLayout.CENTER, mainPanel);
        setUpMidi(); //make the sequencer ready to accept the Midievent
        frame.setSize(300,300);
        frame.pack();
        frame.setVisible(true);

    }//close the buildGui method

    public void setUpMidi() {
    try
    {
        sequencer = MidiSystem.getSequencer();
        sequencer.open();
        sequence = new Sequence(Sequence.PPQ,4);
        track = sequence.createTrack();
        sequencer.setTempoInBPM(120);
    }
    catch(Exception ex){
        ex.printStackTrace();
    }
    }   //close the Midi method

    public void buildTrackAndStart() {
        int[] trackList = null;
        sequence.deleteTrack(track);
        track = sequence.createTrack();

        for(int i=0; i<instrumentNames.length;i++)
        {
            trackList = new int[16];
            int instrumentKey = instrument[i];
            for(int j =0; j<16;j++)
            {
                JCheckBox jc = checkBoxList.get(j + 16*i);
                if(jc.isSelected())
                    trackList[j] = instrumentKey;
                else trackList[j] =0;
            }//close inner loop
            makeTrack(trackList);
            track.add(makeEvent(176,1,127,0,16));
        }//close the outer loop

        track.add(makeEvent(192,9,1,0,15));
        try {
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
            sequencer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//close the buildTrackAndStart method

    class MyStartListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            buildTrackAndStart();
        }
    }//close the MyStartListener class

    class MyStopListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            sequencer.stop();
        }
    }//close the MySStopListener class

    class MyUpTempListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            float tempo = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float)(tempo*1.03));
        }
    }//close the MyUpTempListener class

    class MyDownTempListener implements ActionListener {
        public void actionPerformed (ActionEvent ev) {
            float tempo = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float)(tempo*0.97));
        }
    }//close the MyDownTempListener class

    public void makeTrack(int[] list) {
        for(int i=0;i<list.length;i++)
        {
            if(list[i]!=0)
                {
                    track.add(makeEvent(144,9,list[i],100,i));
                    track.add(makeEvent(128,9,list[i],100,i+1));
                }
        }
    }//close the makeTrack method

    public MidiEvent makeEvent(int comd, int chanel, int one, int two, int tick){
        MidiEvent event = null;
        try{
            ShortMessage a = new ShortMessage();
            a.setMessage(comd,chanel,one,two);
            event = new MidiEvent(a, tick);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return event;
    }//close the makeEvent method

    public class MySaveListener implements ActionListener {
        public void actionPerformed (ActionEvent ev) {
            boolean[] state = new boolean[256];
            for(int i=0;i<checkBoxList.size();i++)
            {
                JCheckBox check = checkBoxList.get(i);
                if(check.isSelected())
                    state[i] = true;
            }
            try (FileOutputStream fileStream = new FileOutputStream("SaveState.ser")){
                ObjectOutputStream os = new ObjectOutputStream(fileStream);
                os.writeObject(state);
                os.close();
            } catch (Exception e) {
                e.printStackTrace();//TODO: handle exception
            }
        }//close the actionPerformed method
    }//close the MySaveListener class

    public class MyRestoreListener implements ActionListener {
        public void actionPerformed (ActionEvent ev) {
            boolean[] getState = new boolean[256];
            try(FileInputStream inputStream = new FileInputStream("SaveState.ser")) {
                ObjectInputStream is = new ObjectInputStream(inputStream);
                getState = (boolean[])is.readObject();
            } catch (Exception e) {
                e.printStackTrace();//TODO: handle exception
            }

            for(int i=0;i<256;i++)
            {
                JCheckBox jc = checkBoxList.get(i);
                if(getState[i])
                    jc.setSelected(true);
                else jc.setSelected(false);
            }
            sequencer.stop();
            buildTrackAndStart();
        }//close the actionPerformed method
    }//close the MyRestoreListener class
}//close the beatbox class, outerclass