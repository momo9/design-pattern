package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Monitor extends Remote {
    public String getLoc() throws RemoteException;
}
