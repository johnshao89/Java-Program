public class test {
    public static void main(String[] args)
    {
        int n1 =12;
        int n2 = 30;
        int n3 = -43;

        int max = ( (n1>n2) ? n1: n2)>n3? ((n1>n2) ? n1: n2):n3;
        System.out.println(max);
    }
}