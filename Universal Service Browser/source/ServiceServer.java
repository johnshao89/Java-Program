import java.rmi.Remote;

/*

    This is the interface to be implemented on the server end

*/
import java.rmi.*;

public interface ServiceServer extends Remote{
    
    public Object[] getServiceList() throws RemoteException; //this method is used to get the key of different services

    public Service getService() throws RemoteException; //this method is used to get the exact service object
}//close the ServiceServer interface
