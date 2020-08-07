import java.util.*;

import java.io.*;

public class DotComBust {
    private int numOfGuess=0;
    private GameHelper helper = new GameHelper();
    ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
    
    //the start of main method
    public static void main(String[] args)
    {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }

    //the start of setUpGame method
    private void setUpGame(){
    DotCom one = new DotCom();
    DotCom two = new DotCom();
    DotCom three = new DotCom();
    dotComList.add(one);
    dotComList.add(two);
    dotComList.add(three);
    one.setName("pets.com");
    two.setName("etyos.com");
    three.setName("Go2.com");
    System.out.println("Your goal is to sink three dot coms.");
    System.out.println("Pets.com, etyos.com, go2.com");
    System.out.println("Try to sink them all in fewest number of guesses.");
    for(DotCom dotComToSet: dotComList)
    {
        ArrayList<String> newLocations = helper.placeDotCom(3);
        dotComToSet.setLocation(newLocations);
    }

    } //the end of setupgame method

    private void startPlaying() {
        while(!dotComList.isEmpty())
        {
            String userGuess = helper.getUserInput("Enter a guess");
            checkUserGuess(userGuess);
        }
        finishGame();
    }



    //The start of DotCom class code
    public class DotCom {
        ArrayList<String> locations = new ArrayList<String>();
        String result = "miss";
        String docName;

        //Set the doc com name
        public void setName(String userName) {
            docName = userName;
        }

        public void setLocation(ArrayList<String> userLocation) {
            locations = userLocation;
        }

        public String checkYourself(String userInput) {
            int index = locations.indexOf(userInput);
            if(index>=0)
            {
                locations.remove(index);
                if(locations.isEmpty())
                result = "Kill";
                else result = "Hit";
            }
            return result;
        }
    }

    //The start of GameHelper class
    public class GameHelper {
        private static final String alphabet ="abcdefg";
        private int gridSize = 49;
        private int gridLength = 7;
        private int[] grid = new int[gridSize];
        private int comCount=0;

        public String getUserInput(String prompt) {
            String inputLine = null;
            System.out.println(prompt + " ");
            try{
                BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
                inputLine = is.readLine();
                if(inputLine.length()==0)
                return null;
            }
            catch(IOException e) {
                System.out.println("IOException" + e);                
            }
            return inputLine.toLowerCase();
        }

        public ArrayList<String> placeDotCom(int comSize) {
            ArrayList<String> alphaCells = new ArrayList<String>();
            //String[] alphacoods = new String[comSize];
            int[] coods = new int[comSize];
            String temp = null;
            boolean success = false;
            int location =0;
            int attemps=0;

            comCount++;
            int incr =1;
            if(comCount%2==1)
            incr = gridLength;

            while(!success && attemps++<200) //arrange the location for one dotcom
            {
                int x =0;
                location = (int)(Math.random()*gridSize); //initial location
                success = true;
                while(success && x< comSize)
                {
                    if(grid[location]==0)
                    {
                        coods[x++] = location; //increase the dotcom length
                        location +=incr;
                        if(location>=gridSize)
                        success = false;
                        if(x>0 && location%gridLength==0)
                        success = false;
                    }
                    else success = false;
                }
            }
            //following code to transform integer coods to a2,f3, etc
            int x=0;
            int row=0,colum=0;
            while (x <comSize)
            {
                grid[coods[x]]=1;
                row = (int)(coods[x] / gridLength);
                colum = coods[x]%gridLength;
                temp = String.valueOf(alphabet.charAt(colum)); //transform the colum integer to alphabet
                alphaCells.add(temp.concat(Integer.toString((row))));
            }
            return alphaCells;
        }
    } //The end of GameHelper class

    //The start of checkUserGuess method
    private void checkUserGuess(String userGuess)
    {
        numOfGuess++;
        String result = "miss";
        for(DotCom dotComToTest: dotComList)
        {
            result = dotComToTest.checkYourself(userGuess);
            if(result.equals("hit"))
            break;
            if(result.equals("kill"))
            dotComList.remove(dotComToTest);
            break;
        }
        System.out.println(result);
    }

    //The start of finish method for DotComBust
    private void finishGame() {
        System.out.println("All Dot are dead! Your stock is now worthless.");
        if(numOfGuess<18){
            System.out.println("It only took you " +numOfGuess + " guesses.");
            System.out.println("You got out before your options sank.");
        }
        else {
            System.out.println("You took long enough." + numOfGuess + " guesses.");
            System.out.println("Fish are dancing with your options.");
        }
    } // The end of finish method
    
}