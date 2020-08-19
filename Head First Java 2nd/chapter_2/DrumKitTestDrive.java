//package chapter_2;

public class DrumKitTestDrive {

    public static void main(String[] args)
    {
        DrumKit d = new DrumKitTestDrive().new DrumKit();
        d.playSnare();
        d.playTopHat();   
    }
    //The start of DrumKit class
    public class DrumKit{
        boolean topHat = true;
        boolean snare = true;
        void playTopHat(){
            System.out.println("ding ding da-ding");
        }
        void playSnare(){
            System.out.println("Bang bang ba-bang");
        }
    }
    //The end of DrumKit class
    
}