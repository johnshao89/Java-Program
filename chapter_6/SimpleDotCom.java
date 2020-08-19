package chapter_6;

import java.util.ArrayList;

public class SimpleDotCom {
    private int numOfHits =0;
    private String result = "miss";
    private ArrayList<String> locationCells = new ArrayList<String>();

    //method start here
    public void setLocations(ArrayList<String>userLocation)
    {
        locationCells = userLocation;
    }

    public String checkYourself(String userInput)
    {
        int index = locationCells.indexOf(userInput);
        if(index >=0)
        {
            numOfHits++;
            locationCells.remove(index);
            if(locationCells.isEmpty())
            result = "kill";
            else result = "hit";
        }
        return result;
    }
}