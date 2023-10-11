package xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.xml.bind.*;
public class Main {
	
	public static void marshal(Long id, String nom, String prenom) throws JAXBException {
		user b = new user();
		b.setId(id);
		b.setNom(nom);
		b.setPrenom(prenom);
		JAXBContext context = JAXBContext.newInstance(user.class);
		Marshaller mar = context.createMarshaller();
		mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		mar.marshal(b, new File("./user"+id+".xml"));
	}
	public static user unmarshal(Long id) throws JAXBException, FileNotFoundException {
		
		JAXBContext context = JAXBContext.newInstance(user.class);
		return (user) context.createUnmarshaller().unmarshal(new FileReader("./user"+id+".xml"));
	};
	
	public user unmarshal() throws JAXBException, FileNotFoundException{
		
		JAXBContext context = JAXBContext.newInstance(user.class);
		return (user) context.createUnmarshaller().unmarshal(new FileReader("./user.xml"));
	}
	
	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		int a = 10;
		Long id;
		String nom;
		String prenom;
		Scanner sc = new Scanner(System.in);
		while(a != 0) {
		System.out.println("entrer choix:");
		System.out.println("1: ajouter nouveau utilisateur");
		System.out.println("2: chercher utilisateur");
		a = sc.nextInt();
		switch(a) {
		case 1:
			System.out.println("entrer id");
			id = sc.nextLong();
			System.out.println("entrer nom");
			nom = sc.next();
			System.out.println("entrer prenom");
			prenom = sc.next();	
			marshal(id, nom, prenom);
			break;
		case 2:
			System.out.println("entrer id:");
			id = sc.nextLong();
			System.out.println(unmarshal(id).toString());
			break;
		}
	}
	}
}
