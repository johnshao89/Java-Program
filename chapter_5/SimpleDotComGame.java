//package chapter_5;
import java.io.*;

//import jdk.internal.org.jline.utils.InputStreamReader;
//import sun.java2d.pipe.SpanShapeRenderer.Simple;

public class SimpleDotComGame {
    public static void main(String[] args)
    {
        int numOfGuess=0;
        String result;
        SimpleDotCom dotCom = new SimpleDotComGame().new SimpleDotCom();
        GameHelper helper = new SimpleDotComGame().new GameHelper();
        int rand = (int)(Math.random()*5);
        int[] locations ={rand, rand+1, rand+2};
        dotCom.setLocation(locations);
        while(true)
        {
            String input = helper.getUserInput("Enter your guess:");
            result = dotCom.checkYourself(input);
            System.out.println(result);
            numOfGuess++;
            if(result.equals("kill"))
            break;
        }
        System.out.println("You have killed a dotcom with "+numOfGuess + " guesses.");
    }
    //the start of SimpleDotCom class
    public class SimpleDotCom{
        private int numOfHits =0;
        private String result = "miss";
        private int[] locationCells = new int[3];

        //begin of methods
        public void setLocation(int[] randomLocation)
        {
            locationCells = randomLocation;
        }
        
        public String checkYourself(String userInput)
        {
            for(int cell: locationCells)
            {
                if(cell == Integer.parseInt(userInput))
                {
                    numOfHits++;
                    result = "hit";
                    break;
                }
            }
            if(numOfHits==locationCells.length)
            result = "kill";
            return result;
        }
    }
    //the end of SimpleDotCom class

    //the start of gamehelper
    public class GameHelper{
        public String getUserInput(String prompt){
            String inputLine = null;
            System.out.print(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if(inputLine.length()==0)
            return null;
        } catch (IOException e) {
            System.out.println("IOException" + e);
        }
        return inputLine;
        }
    }
    //the end of GameHelper class
}