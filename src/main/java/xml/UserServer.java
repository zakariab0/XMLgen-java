package xml;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserServer extends Remote {
    void addUser(Long id, String nom, String prenom) throws RemoteException;
    User getUser(Long id) throws RemoteException;
}
