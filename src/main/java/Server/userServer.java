import java.rmi.Remote;
import java.rmi.RemoteException;

import xml.user;

public interface userServer extends Remote {
    void addUser(Long id, String nom, String prenom) throws RemoteException;
    user getUser(Long id) throws RemoteException;
}
