import java.io.*;
import java.util.*;
    //the start of DotCom class
    class DotCom{
        String result = "miss";
        ArrayList<String>locationCells = new ArrayList<String>();
        String name;

        public void setName(String userName){
            name = userName;
        }

        public void setLocation(ArrayList<String>userLocation){
            locationCells = userLocation;
        }

        public String checkYourself(String userInput){
            int index = locationCells.indexOf(userInput);
            if(index>=0)
            {
                locationCells.remove(index);
                if(locationCells.isEmpty())
                result = "kill";
                else result = "hit";
            }
            return result;
        }
    }
    //the end of DotCom class

    //the start of GameHelper class
    class GameHelper{

        public String getUserInput(String prompt) {
            String inputLine = null;
            System.out.println(prompt + " ");
            try {
                BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
                inputLine = is.readLine();
                if(inputLine.length()==0) return null;
            }
            catch (IOException e) {
                System.out.println("IOException" + e);
            }
            return inputLine;
        }

    private static final String alphabet = "abcdefg";
    private int gridSize = 49;
    private int gridLength = 7;
    private int dotCount =0;
    private int[] grid = new int[gridSize];

    public ArrayList<String> makeLocation(int comSize) {
        ArrayList<String>alphaCell = new ArrayList<String>();
        int[] cords = new int[comSize];
        boolean success = false;
        int attempts = 0;
        dotCount++;
        int incr = 1;
        if(dotCount%2 ==1)
            incr = gridLength;
        while(!success && attempts++<200)
        {
            int initPlace = (int)(Math.random()*gridSize);
            int x =0;
            success = true;
            while(success && x < comSize)
            {
                if(grid[initPlace]==0)
                {
                    cords[x++] = initPlace;
                    initPlace+= incr;
                    if(initPlace>gridSize)
                    success = false;
                    if(x>0 && initPlace%gridLength==0)
                    success = false;
                }
                else success = false;
            }
        }

        int x=0;
        int row=0, col =0;
        while(x < comSize)
        {
            grid[cords[x]]=1;
            row = grid[cords[x]] % gridLength;
            col = grid[cords[x]]/gridLength;
            String temp = String.valueOf(alphabet.charAt(row));
            alphaCell.add(temp.concat(Integer.toString(col)));
        }

        return alphaCell;
    } 
    }
    //the end of GameHelper class
    public class DotComBust {
    private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
    private GameHelper helper = new GameHelper();
    private int numOfGuess = 0;
    //the start of DotComBust method
    private void setGame() {

        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);
        for(DotCom dot: dotComList)
        {
            dot.setLocation(helper.makeLocation(3));
        }
    }
    //the end of DotCom Bust method

    private void startGame(){
        while(!dotComList.isEmpty())
        {
            checkUserGuess(helper.getUserInput("Enter a guess"));
        }
        finishGame();
    }

    public void checkUserGuess(String userGuess)
    {
        String result = "miss";
        numOfGuess++;
        for(DotCom dot: dotComList)
        {
            result = dot.checkYourself(userGuess);
            if(result.equals("hit"))
            break;
            if(result.equals("kill"))
            {
                dotComList.remove(dot);
                break;
            }
        }
        System.out.println(result);        
    }

    public void finishGame() {
        System.out.println("All dots are dead!");
        System.out.println("You used " + numOfGuess + " guesses.");
    }

    public static void main(String[] args)
    {
        DotComBust bust = new DotComBust();
        bust.setGame();
        bust.startGame();
    }
}

