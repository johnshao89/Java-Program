//package Head First Java 2nd.chapter_13;
import javax.swing.*;
import java.awt.*;
public class Panel1 {
    public static void main(String[] args) {
        Panel1 gui = new Panel1();
        gui.go();
    }//close the main method

    public void go() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton button = new JButton("shock me");
        JButton button2 = new JButton("bliss");
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBackground(Color.darkGray);
        panel.add(button);
        panel.add(button2);
        frame.getContentPane().add(BorderLayout.EAST, panel);
        frame.setSize(300,300);
        frame.setVisible(true);
    }//close the go method
}