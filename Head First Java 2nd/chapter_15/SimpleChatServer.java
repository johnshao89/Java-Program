import java.net.*;
import java.util.*;
import java.io.*;

public class SimpleChatServer {
    ArrayList clientOutputStream;
    public class ClientHanlde implements Runnable {
        Socket sock;
        BufferedReader reader;
        public ClientHanlde(Socket clientSocket) {
            try {
                sock = clientSocket;
                InputStreamReader is = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(is);
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        public void run() {
            String message;
            try {
                while((message = reader.readline())!=null)
                {
                    System.out.println("read" + message);
                    tellEveryone(message);
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//close the inner class clienthandle

    public static void main(String[] args) {
        SimpleChatServer server = new SimpleChatServer();
        server.go();
    }//close the main method

    public void go() {
        clientOutputStream = new ArrayList<>();
        try(ServerSocket serverSocket = new ServerSocket(5000)){
            while(true) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                clientOutputStream.add(writer);
                Thread t = new Thread(new ClientHanlde(clientSocket));
                t.start();
                System.out.println("got a connection!");
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }//close the go method

    public void tellEveryone(String message) {
        Iterator it = clientOutputStream.iterator();
        while(it.hasNext()) {
            try {
                PrintWriter writer = (PrintWriter)it.next();
                writer.println(message);
                writer.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//close the tellEveryone method
}
