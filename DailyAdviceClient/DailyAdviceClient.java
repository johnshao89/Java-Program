import java.io.*;
import java.net.*;

public class DailyAdviceClient {
    public static void main(String[] args)
    {
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }

    public void go()
    {
        try (Socket sock = new Socket("127.0.0.1",4242)) {
            InputStreamReader stream = new InputStreamReader(sock.getInputStream());
            BufferedReader reader = new BufferedReader(stream);
            String advice = reader.readLine();
            System.out.println("Today you should "+advice);
        } catch (IOException e) {
            e.printStackTrace();//TODO: handle exception
        }
    }
}
