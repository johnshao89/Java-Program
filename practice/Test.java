import java.util.Scanner;
class Test{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        char letter = input.charAt(0);
        switch(letter){
            case 'a':
                letter = 'A';
                System.out.println('A');
                break;
            case 'b':
                letter = 'B';
                System.out.println('B');
                break;
            case 'c':
                letter = 'C';
                System.out.println('C');
                break;
            default:
                break;
        }
        
    }
}