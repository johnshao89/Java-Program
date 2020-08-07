//package chapter_4;
class GoodDog {
    private int size;
    public int getSize() {
        return size;
    }
    public void setSize(int s) { //only setter method can access the private instance variable
        size = s;
    }
    void bark() {
        if(size>80) {
            System.out.println("Wooff!");
        }
        else if (size >14) {
            System.out.println("puff!");
        }
        else {
            System.out.println("YipYIP!");
        }
    }
}

class GoodDogTestDrive {
    public static void main(String[] args) {
        GoodDog one = new GoodDog();
        one.setSize(70);
        GoodDog two = new GoodDog();
        two.setSize(80);
        System.out.println("Dog one " + one.getSize());
        System.out.println("Dog two " + two.getSize());
        one.bark();
        two.bark();
    }
}