import java.io.*;
import java.util.ArrayList;

public class SimpleDotComGame {
    public static void main(String[] args)
    {
        int random = (int)(Math.random()*5);
        int numOfGuess =0;
        GameHelper helper = new SimpleDotComGame().new GameHelper();
        int[] locations = {random, random+1, random+2};
        SimpleDotCom dot = new SimpleDotComGame(). new SimpleDotCom();
        DotCom Dot = new SimpleDotComGame(). new DotCom();
        ArrayList<String> new_list = new ArrayList<String>();
        for(int i=0;i<3;i++)
        new_list.add(Integer.toString(random+i));
        Dot.setLocations(new_list);
        dot.setLocation(locations);
        String user_input;
        boolean isAlive = true;
        
        /* Code below test for arraystring */
        while(isAlive)
        {
            user_input = helper.getUserInput("enter a number");
            Dot.checkYourself(user_input);
            numOfGuess++;
            if(Dot.result == "kill")
            isAlive = false;
        }
        System.out.println("You took "+numOfGuess + " guesses.");

        /* Code below for original */
      /*  while(isAlive)
        {
            user_input = helper.getUserInput("enter a number");
            dot.checkYourself(user_input);
            numOfGuess++;
            if(dot.result == "kill")
            isAlive = false;
        }
        System.out.println("You took "+numOfGuess + " guesses.");
        */
    }

    public class GameHelper
    {
        public String getUserInput(String prompt)
        {
            String inputLine = null;
            System.out.print(prompt +" ");
            try
            {
                BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
                inputLine = is.readLine();
                if(inputLine.length()==0)
                return null;
            }
            catch (IOException e)
            {
                System.out.println("IOException: "+e);
            }
            return inputLine;
        }
    }

    public class SimpleDotCom {
        int numOfHits=0;
        int[] location;
        String result = "miss";

        //following code for methods
        public void setLocation(int[] userLoc) {
            location = userLoc;
        }

        public String checkYourself(String user_string) {
            for(int cell: location) {
                if (cell ==Integer.parseInt(user_string))
                {
                    result = "Hit";
                    numOfHits++;
                    break;
                }
            }
            if(numOfHits==location.length)
            result = "kill";
            System.out.println(result);
            return result;
        }
    }

    public class DotCom{
        int numofHits=0;
        private ArrayList<String> locations;
        String result = "miss";

        //following code for method
        public void setLocations(ArrayList<String> userLoc)
        {
            locations = userLoc;
        }

        public String checkYourself(String user_string)
        {
            int index = locations.indexOf(user_string);
            if(index>=0)
            {
                locations.remove(index);
                numofHits++;
                if(locations.isEmpty())
                result = "kill";
                else result = "Hit";
            }
            else result="miss";
            System.out.println(result);
            return result;
        }
    }
}