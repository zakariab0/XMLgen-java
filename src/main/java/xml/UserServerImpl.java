package xml;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.io.File;

import javax.xml.bind.*;

public class UserServerImpl extends UnicastRemoteObject implements UserServer {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2664707684242803690L;
	private Map<Long, User> users;

    public UserServerImpl() throws RemoteException {
        super();
        users = new HashMap<>();
    }

    @Override
    public void addUser(Long id, String nom, String prenom) throws RemoteException {
        User user = new User();
        user.setId(id);
        user.setNom(nom);
        user.setPrenom(prenom);
        users.put(id, user);

        try {
            // Save user data to an XML file
            JAXBContext context = JAXBContext.newInstance(User.class);
            Marshaller marshaller = context.createMarshaller();
    		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(user, new File("./user" + id + ".xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUser(Long id) throws RemoteException {
        User user = users.get(id);
        if (user == null) {
            try {
                JAXBContext context = JAXBContext.newInstance(User.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                user = (User) unmarshaller.unmarshal(new File("./user" + id + ".xml"));
            } catch (JAXBException e) {
                e.printStackTrace();
                return null; // User not found
            }
        }
        return user;
    }

    public static void main(String[] args) {
        try {
            UserServer server = new UserServerImpl();
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            java.rmi.Naming.rebind("UserServer", server);
            System.out.println("Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
