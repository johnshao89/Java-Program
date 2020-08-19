public class UseADuck {
    public static void main(String[] args)
    {
        
        Duck myDuck = new Duck(42);
    }
}

class Duck{
    int size;
    public Duck(int duckSize)
    {
        size = duckSize;
        System.out.println("Quack!");
        System.out.println(size);
    }
}