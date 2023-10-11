package xml;

import java.rmi.Naming;
import java.util.Scanner;

public class UserClient {
    public static void main(String[] args) {
        try {
            UserServer server = (UserServer) Naming.lookup("rmi://localhost/UserServer");
            Scanner sc = new Scanner(System.in);
            int choice = 1;

            while (choice != 0) {
                System.out.println("Enter choice:");
                System.out.println("1: Add a new user");
                System.out.println("2: Get user by ID");
                System.out.println("0: Exit");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter ID:");
                        Long id = sc.nextLong();
                        System.out.println("Enter name:");
                        String nom = sc.next();
                        System.out.println("Enter surname:");
                        String prenom = sc.next();
                        server.addUser(id, nom, prenom);
                        break;
                    case 2:
                        System.out.println("Enter ID:");
                        id = sc.nextLong();
                        User user = server.getUser(id);
                        if (user != null) {
                            System.out.println("User: " + user.toString());
                        } else {
                            System.out.println("User not found.");
                        }
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
