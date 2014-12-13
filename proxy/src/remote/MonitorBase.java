package remote;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public abstract class MonitorBase implements Monitor {
    
    protected String loc;
    
    public MonitorBase(String loc) {
        this.loc = loc;
    }

    @Override
    public String getLoc() throws RemoteException {
        return loc;
    }
    

    protected static void register(Monitor monitorRemote, int port) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        
        try {
            Monitor stub = (Monitor) UnicastRemoteObject.exportObject(monitorRemote, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("Monitor", stub);
            System.out.println("bound");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
 
    
}
