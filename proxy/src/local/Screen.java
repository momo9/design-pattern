package local;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import remote.Monitor;

public class Screen {
    public String getLoc(String hostName, int port) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        
        String ret = null;
        
        try {
            Registry registry = LocateRegistry.getRegistry(hostName, port);
            Monitor monitor = (Monitor) registry.lookup("Monitor");
            ret = monitor.getLoc();
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
