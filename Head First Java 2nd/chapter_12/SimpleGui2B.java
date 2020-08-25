//package Head First Java 2nd.chapter_12;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SimpleGui2B{ //the outer class does not implements listener class
    JFrame frame;
    JLabel label;
    public static void main(String[] args) {
        SimpleGui2B gui = new SimpleGui2B();
        gui.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label = new JLabel("I'm a label");
        JButton labelButton = new JButton("Change label button");
        labelButton.addActionListener(new LabelAction());
        JButton colorButton = new JButton("Change color button");
        colorButton.addActionListener(new ColorAction());
        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.CENTER,drawPanel);
        frame.getContentPane().add(BorderLayout.SOUTH,colorButton);
        frame.getContentPane().add(BorderLayout.EAST,labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setSize(300,300);
        frame.setVisible(true);
        
    }

    class LabelAction implements ActionListener{
    public void actionPerformed(ActionEvent event) {
        label.setText("changed texts");
        }
    }

    class ColorAction implements ActionListener {
        public void actionPerformed (ActionEvent event) {
            frame.repaint();
        }
    }
}

class MyDrawPanel extends JPanel {
    public void paintComponent(Graphics g) {
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        int red = (int)(Math.random()*255);
        int green = (int)(Math.random()*255);
        int blue = (int)(Math.random()*255);
        Color randomColor = new Color(red, green, blue);
        g.setColor(randomColor);
        g.fillOval(20, 20, 50, 50);
    }
}