package xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="book")
@XmlType(propOrder = {"id", "nom", "prenom"})
public class User implements Serializable{

	private Long id;
	private String nom, prenom;
	public Long getId() {
		return id;
	}
	
	@XmlAttribute
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}

	@XmlAttribute
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	
	@XmlAttribute
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", getId()=" + getId() + ", getNom()="
				+ getNom() + ", getPrenom()=" + getPrenom() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
