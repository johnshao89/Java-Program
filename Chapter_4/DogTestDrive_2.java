package chapter_4;
class Dog_2 {
    int size;
    void bark (int numOfBarks) {
        while(numOfBarks>0)
        {
            System.out.println("puff!");
            numOfBarks--;
        }
    }
}

class DogTestDrive_2 {
    public static void main(String[] args){
        Dog_2 one = new Dog_2();
        one.bark(3);
    }

}