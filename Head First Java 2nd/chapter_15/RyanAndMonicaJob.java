class BankAccount {
    private int balance =100;

    public int getBalance() {
        return balance;
    }

    public void withdraw (int amount) {
        balance -=amount;
    }
}
public class RyanAndMonicaJob implements Runnable{
    private BankAccount account = new BankAccount();

    public static void main(String[] args) {
        RyanAndMonicaJob theJob = new RyanAndMonicaJob();
        Thread one = new Thread(theJob);
        Thread two = new Thread(theJob);
        one.setName("Ryan");
        two.setName("Monica");
        one.start();
        two.start();
    }

    public void run() {
        for (int x =0;x<10;x++) {
            makeWithdraw(10);
            if(account.getBalance()<0) {
                System.out.println("Overdrawn!");
            }
        }
        }//close the run method

        private void makeWithdraw (int amount) {
            if(account.getBalance()>amount) {
                System.out.println(Thread.currentThread().getName() + " is going to withdraw.");
                try {
                    System.out.println(Thread.currentThread().getName()+ " is going to sleep");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();//TODO: handle exception
                }
                System.out.println(Thread.currentThread().getName() +" woke up.");
                account.withdraw(amount);
                System.out.println(Thread.currentThread().getName() +" completes transaction");
            }//close the if
            else {
                System.out.println("Not enough money!");
            }

        }//close the makeWithdraw method
    }

