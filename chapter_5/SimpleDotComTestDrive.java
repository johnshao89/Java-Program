

public class SimpleDotComTestDrive
{
    public static void main(String[] args) {
        int[] location = { 2, 3, 4 };
        String choice = "2";
        SimpleDotCom dot = new SimpleDotComTestDrive(). new SimpleDotCom();

        dot.setLocation(location);
        dot.checkYourself(choice);

    }

    public class SimpleDotCom {
        int[] location;
        int numOfGuess = 0;
        int numOfHits = 0;
        String result = "miss";

        // Following code for method
        public void setLocation(final int[] userLocation) {
            location = userLocation;
        }

        public String checkYourself(final String userGuess) {
            for (int cell : location)
            {
                if(cell == Integer.parseInt(userGuess))
                {
                    numOfHits++;
                    numOfGuess++;
                    result = "hit";
                    break;
                }
            }
            if(numOfHits==location.length)
            result = "kill";
            System.out.println(result);
            return result;
        }
    }

    
    
}