import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.text.*;
import java.util.*;

public class DayOfTheWeekService {
    JLabel label;
    JComboBox month;
    JTextField day;
    JTextField year;

    public JPanel getGuiJPanel() {
        JPanel mainPanel = new JPanel();
        JButton button = new JButton("Do it!");
        button.addActionListener(new DoItListener());
        label = new JLabel("Text goes here");
        DateFormatSymbols dateStuff = new DateFormatSymbols();
        month = new JComboBox<>(dateStuff.getMonths());
        day = new JTextField(8);
        year = new JTextField(8);
        JPanel panel = new JPanel(new GridLayout(3,2));
        panel.add(new JLabel("Month"));
        panel.add(month);
        panel.add(new JLabel("Day"));
        panel.add(day);
        panel.add(new JLabel("Year"));
        panel.add(year);
        mainPanel.add(panel);
        mainPanel.add(button);
        mainPanel.add(label);
        return mainPanel;
    }

    public class DoItListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            int monthNum = month.getSelectedIndex();
            int dayNum = Integer.parseInt(day.getText());
            int yearNum = Integer.parseInt(year.getText());
            Calendar c = Calendar.getInstance();
            c.set(Calendar.MONTH,monthNum);
            c.set(Calendar.YEAR, yearNum);
            c.set(Calendar.DAY_OF_MONTH,dayNum);
            Date date = c.getTime();
            String dayOfTheWeek = (new SimpleDateFormat("EEEE")).format(date);
            label.setText(dayOfTheWeek);
        }
    }
}
