import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class QuizCardPlayer {
    private JTextArea display;
    private JButton nextButton;
    JFrame frame;
    ArrayList<QuizCard> cardList;
    QuizCard currentCard;
    int currentCardIndex;
    boolean isShowAnswer;
    
    public static void main(String[] args) {
        QuizCardPlayer player = new QuizCardPlayer();
        player.go();
    }

    public void go() {                                   /* go method for GUI building */

        frame = new JFrame("Quiz Card Player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();

        display = new JTextArea(10,20);
        display.setLineWrap(true);
        display.setWrapStyleWord(true);
        display.setEditable(false);
        JScrollPane dScroller = new JScrollPane(display);
        dScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        dScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        nextButton = new JButton("Show Question");
        nextButton.addActionListener(new NextButtonListener());
        
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenuItem loadFile = new JMenuItem("Load");
        loadFile.addActionListener(new MyLoadListener());
        menuFile.add(loadFile);
        menuBar.add(menuFile);

        mainPanel.add(display);
        mainPanel.add(nextButton);
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(mainPanel);

        frame.setSize(500,650);
        frame.setVisible(true);
    }//close the go method

    public class NextButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            if(isShowAnswer) {
                display.setText(currentCard.getAnswer());
                isShowAnswer = false;
                nextButton.setText("Next Card");
            }
            else {
                if(currentCardIndex < cardList.size())
                    showCard();
                else {
                    display.setText("That's the end of card!");
                    nextButton.setEnabled(false);}
            }
        }
    }//close the NextButtonListener inner class

    private void showCard() {
        currentCard = cardList.get(currentCardIndex);
        currentCardIndex++;
        display.setText(currentCard.getQuestion());
        isShowAnswer = true;
        nextButton.setText("Show Answer");

    }//close the showCard method

    public class MyLoadListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.showOpenDialog(frame);
            openFile(fileOpen.getSelectedFile());
        }

        private void openFile(File file) {
            String[] results = null;
            cardList = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line = null;
                while((line=reader.readLine())!=null) {
                    results = line.split("/");
                    QuizCard card = new QuizCard(results[0],results[1]);
                    cardList.add(card);
                }
                showCard();
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }//close the private openFile method
    }//close the inner myloadlistener class

    public class QuizCard {
        private String question;
        private String answer;
        public QuizCard (String q, String a){
            question = q;
            answer = a;
        }//close the quizcard constructor

        public String getQuestion() {
            return question;
        }
        public String getAnswer() {
            return answer;
        }
    }//close the inner quizcard
}


