import java.rmi.*;
import java.rmi.server.*;
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote{
    public MyRemoteImpl() throws RemoteException{};

    public String sayHello() {
        return "server say, 'hey'";
    }

    public static void main(String[] args) {
        try{
        MyRemote service = new MyRemoteImpl();
        Naming.rebind("Remote Hello", service);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
