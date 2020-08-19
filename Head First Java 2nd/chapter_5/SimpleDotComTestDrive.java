//package chapter_5;

public class SimpleDotComTestDrive {
    public static void main(String[] args)
    {
        SimpleDotCom dotCom = new SimpleDotComTestDrive().new SimpleDotCom();
        int[] userLocation = {2,3,4};
        String userInput ="2";
        dotCom.setLocations(userLocation);
        String result = dotCom.checkYourself(userInput);
        System.out.println(result);
    }
    



    //The start of SimpleDotCom class
    public class SimpleDotCom{
        private int numOfHits=0;
        private String result = "miss";
        private int[] locationCells;

        //methods starts
        public void setLocations(int[] userLocation)
        {
            locationCells = userLocation;
        }

        public String checkYourself(String userInput)
        {
            int x;
            for(x=0;x<locationCells.length;x++) //can also use for(int cell: locationCells)
            {
                if(locationCells[x] == Integer.parseInt(userInput))
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
}