
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class ServiceServerImpl extends UnicastRemoteObject implements ServiceServer {
    
    HashMap serviceList;

    public ServiceServerImpl() throws RemoteException {
        setUpService();
    }

    private void setUpService() {
        serviceList = new HashMap<>();
        serviceList.put("Day of the Week Service", new DayOfTheWeekService());
        serviceList.put("Dice Rolling Service", new DiceService());
        serviceList.put("Visual Music Service", new MiniMusicService());
    }//close the setUpService method

    public Object[] getServiceList() {      //this method return an array of object of the service key(name)
        System.out.println("in remote");
        return serviceList.keySet().toArray();
    }//close the getservicelist method

    public Service getService(Object serviceKey) {
        Service theService = (Service)serviceList.get(serviceKey);
        return theService;
    }//close the getservice method

    public static void main(String[] args) {
        try {
            Naming.rebind("ServiceServer", new ServiceServerImpl());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Remote service is running!");
    }
}
