
import java.io.*;

public class GameSaverTest {
    public static void main(String[] args) {
        GameCharacter one = new GameCharacter(50, "Elf", new String[] {"bow, sword","dust"});
        GameCharacter two = new GameCharacter(200,"troll",new String[] {"bare hands","big ax"});
        GameCharacter three = new GameCharacter(120,"Magician", new String[] {"spells","invisibility"});

        try(FileOutputStream fileStream = new FileOutputStream("MyGame.ser")) {
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();//TODO: handle exception
        }//close the try/catch

        one = null;
        two = null;
        three = null;

        try (FileInputStream fileIn = new FileInputStream("MyGame.ser")){
            ObjectInputStream is = new ObjectInputStream(fileIn);
            GameCharacter oneResotre = (GameCharacter)is.readObject();
            GameCharacter twoResotre = (GameCharacter)is.readObject();
            GameCharacter threeRestore = (GameCharacter)is.readObject();
            System.out.println("one's type " + oneResotre.getType());
            System.out.println("two's type " + twoResotre.getType());
            System.out.println("three's type " + threeRestore.getType());
            is.close();
        } catch (Exception e) {
            e.printStackTrace();//TODO: handle exception
        }
    }    
}

class GameCharacter implements Serializable{
    private int power;
    private String[] weapons;
    private String type;
    public GameCharacter(int p, String t, String[] list) {
        power = p;
        type = t;
        weapons = list;
    }

    public int getPower(){
        return power;
    }

    public String getType(){
        return type;
    }

    public String getWeapons() {
        String weaponList ="";
        for(String val:weapons)
            weaponList+=val+" ";
        return weaponList;
    }
}