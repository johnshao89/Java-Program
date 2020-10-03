import java.io.*;
import java.net.*;

public class DailyAdviceServer {
    public String[] adviceList = {"take smaller bites","make you look fat","one word: inappriorate"}
    public static void main(String[] args)
    {
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }

    public void go()
    {
        try(ServerSocket serverSock = new ServerSocket(4242)) {
            while(true)
            {
                Socket sock = serverSock.accept();
                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }
        } catch (IOException e) {
            e.printStackTrace();//TODO: handle exception
        }//close the try-catch block
    }//close the go method

    public String getAdvice()
    {
        int index = (int)(Math.random()*adviceList.length);
        return adviceList[index];
    }
}
