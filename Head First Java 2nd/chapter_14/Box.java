//package chapter_14;

import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Box implements Serializable{
    private int width;
    private int height;
    
    public void setWidth (int w) {
        width = w;
    }

    public void setHeight (int h) {
        height = h;
    }

    public static void main(String[] args) {
        Box myBox = new Box();
        myBox.setHeight(50);
        myBox.setWidth(50);

        
        try (FileOutputStream fileStream = new FileOutputStream("MyBox.ser")){
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(myBox);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();//TODO: handle exception
        }
    }
}