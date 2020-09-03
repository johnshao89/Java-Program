import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class QuizCardBuilder {
    private JFrame frame;
    private JTextArea question;
    private JTextArea answer;
    private JButton nextButton;
    private ArrayList<QuizCard> cardList;

    public static void main(String[] args) {
        QuizCardBuilder builder = new QuizCardBuilder();
        builder.go();
    }//close the main method

    public void go() {
        frame = new JFrame("Quiz Card Builder");
        Font bigFont = new Font("sanserif",Font.BOLD,24);
        JPanel mainPanel = new JPanel();
        question = new JTextArea(6,20);
        question.setLineWrap(true);
        question.setFont(bigFont);
        question.setWrapStyleWord(true);
        JScrollPane qScroller = new JScrollPane(question);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        answer = new JTextArea(6,20);
        answer.setLineWrap(true);
        answer.setWrapStyleWord(true);
        answer.setFont(bigFont);
        JScrollPane aScroller = new JScrollPane(answer);
        aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        cardList = new ArrayList<>();

        JLabel qLabel = new JLabel("Question");
        JLabel aLabel = new JLabel("Answer");
        nextButton = new JButton("Next Card");
        nextButton.addActionListener(new MyNextCardListener());
        mainPanel.add(qLabel);
        mainPanel.add(qScroller);
        mainPanel.add(aLabel);
        mainPanel.add(aScroller);
        mainPanel.add(nextButton);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        newMenuItem.addActionListener(new MyNewListener());
        saveMenuItem.addActionListener(new MySaveListener());
        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(mainPanel);
        frame.setSize(500,650);
        frame.setVisible(true);

    }//close the go method

    public class MyNextCardListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            QuizCard card = new QuizCard(question.getText(),answer.getText());
            cardList.add(card);
            question.setText("");
            answer.setText("");
            question.requestFocus();
        }
    }//close the mynextcardlistener inner class

    public class MyNewListener implements ActionListener {
        public void actionPerformed (ActionEvent ev) {
            question.setText("");
            answer.setText("");
            question.requestFocus();
            cardList.clear();
        }
    }//close the mynewlistener inner class

    public class MySaveListener implements ActionListener { /*choose a file location to save the the file */
        public void actionPerformed(ActionEvent ev) {
            JFileChooser fileSave = new JFileChooser();
            fileSave.showSaveDialog(frame);
            saveFile(fileSave.getSelectedFile());
        }
        private void saveFile (File file) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (QuizCard card:cardList)
                {
                    writer.write(card.getQuestion()+"/");
                    writer.write(card.getAnswer()+"\n");
                    writer.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//close the mysave listener inner class

    public class QuizCard{
        private String question;
        private String answer;
        public QuizCard(String q, String a) {
            question = q;
            answer = a;
        }

        public String getQuestion() {
            return question;
        }

        public String getAnswer() {
            return answer;
        }
    }
}//close the QuizCardBuilder outerclass

