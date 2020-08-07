//package chapter_2;

public class EchoTestDrive {
    //The start of Echo class
    class Echo{
        int count =0;
        void hello(){
            System.out.println("helloooo...");
        }
    }
    //The end of Echo class

    //The start of main method
    public static void main(String[] args)
    {
        Echo e1 = new EchoTestDrive().new Echo();
        Echo e2 = e1;
        int x =0;
        while(x<4)
        {
            e1.hello();
            if(x>0)
            e2.count = e2.count+1;
            if(x>1)
            e2.count = e2.count +e1.count;
            x = x+1;
        }
        System.out.println(e2.count);
    }  
}