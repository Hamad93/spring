package m2gl.sn.hospital.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Medecin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int id;
	 
	 @Column(length=40)
	 private String matricule;
	 
	 @Column(length=40)
	 private String prenom;
	 
	 @Column(length=40)
	 private String nom;
	 
	 private int tel;
	 
	 @Column(length=40)
	 private String adresse;
	 
	 @Temporal(TemporalType.DATE)
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	 private Date datenais;
	 
	 @ManyToOne
	 @JoinColumn(name="service_id")
	 private Service service;
	 
	 @ManyToOne
	 @JoinColumn(name="specialite_id")
	 private Specialite specialite;
	 
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Date getDatenais() {
		return datenais;
	}
	public void setDatenais(Date datenais) {
		this.datenais = datenais;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public Specialite getSpecialite() {
		return specialite;
	}
	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	} 
}
