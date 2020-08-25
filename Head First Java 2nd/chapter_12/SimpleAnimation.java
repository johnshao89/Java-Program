import javax.swing.*;
import java.awt.*;


public class SimpleAnimation {
    int x=0, y=0;
    public static void main(String[] args) {
        SimpleAnimation animation = new SimpleAnimation();
        animation.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyDrawPanel drawPanel = new MyDrawPanel();
        frame.getContentPane().add(drawPanel);
        
        frame.setSize(300,300);
        frame.setVisible(true);

        for(int i=0;i<300;i+=4)
        {
            x++;
            y++;
            drawPanel.repaint();
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                //TODO: handle exception
            }
        }

    }

    class MyDrawPanel extends JPanel {
        public void paintComponent(Graphics g) {
            g.setColor(Color.white);
            g.fillRect(0,0,this.getWidth(),this.getHeight());
            g.setColor(Color.green);
            g.fillOval(x, y, 40, 40);
        }
    }
}