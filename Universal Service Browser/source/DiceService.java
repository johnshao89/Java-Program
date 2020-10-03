import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class DiceService {
    JComboBox numofDice;
    JLabel label;

    public JPanel getGuiPanel() {               //because the return type is JPanel, so no need to make a JFrame instance
        JPanel panel = new JPanel();
        JButton button = new JButton("Roll 'em'");
        String[] choice = {"1","2","3","4","5"};
        numofDice = new JComboBox<>(choice);
        label = new JLabel("The result goes here:");
        button.addActionListener(new DiceRollListener());
        panel.add(numofDice);
        panel.add(button);
        panel.add(label)
    }//close the getGuiPanel method

    public class DiceRollListener implements ActionListener{
        public void actionPerformed(ActionEvent ev) {
            String diceIndex = (String)numofDice.getSelectedIndex();
            int numOfDiceToRoll = Integer.parseInt(diceIndex);
            String result = "";
            for(int i=0;i<diceIndex;i++){
                int randNum = (int)((Math.random()*6)+1);
                result + = " "+randNum;
            }
            label.setText(result);
        }
    }
}
