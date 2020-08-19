//package chapter_2;

public class GameLauncher {
    public static void main(String[] args)
    {
        GuessGame one = new GameLauncher().new GuessGame();
        one.startGame();
    }

    //The begin of player class
    public class Player{
        int number;
        public void guess(){
            number = (int)(Math.random()*10);
            System.out.println("I am guessing " + number);
        }
    }
    //The end of player class

    //The start of GuessGame class
    public class GuessGame{
        Player p1;
        Player p2;
        Player p3;
        public void startGame(){
            int p1guess;
            int p2guess;
            int p3guess;
            p1 = new Player();
            p2 = new Player();
            p3 = new Player();
            boolean p1right = false, p2right = false, p3right = false;
            while(true)
            {
                int targetNumber = (int)(Math.random()*10);
                System.out.println("The three players guesses:");
                p1.guess();
                p2.guess();
                p3.guess();
                p1guess = p1.number;
                p2guess = p2.number;
                p3guess = p3.number;
                if(p1guess==targetNumber)
                p1right = true;
                if(p2guess == targetNumber)
                p2right = true;
                if(p3guess == targetNumber)
                p3right = true;
                if(p1right || p2right || p3right)
                {
                    System.out.println("We have a winner!");
                    System.out.println("Player one got it right? " + p1right);
                    System.out.println("Player two got it right? " + p2right);
                    System.out.println("Player three got it right? " + p3right);
                    break;
                }
                else
                System.out.println("No one got it right! They will try again!");

            }
        }
    }
    // The end of GuessGame class
}