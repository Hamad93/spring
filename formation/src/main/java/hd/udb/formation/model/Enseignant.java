package hd.udb.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Enseignant {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int id;
	 
	 @Column(length=40)
	 private String nom;
	 
	 @Column(length=40)
	 private String prenom;
	 
	 @Column(length=40)
	 private String tel;
	 
	 @Column(length=40)
	 private String email;
	 
	 public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	 
	 
}
