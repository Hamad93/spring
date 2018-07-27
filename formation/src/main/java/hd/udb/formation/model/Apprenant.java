package hd.udb.formation.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Apprenant {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int id;
	 
	 @Column(length=40)
	 private String matricule;
	 
	 @Column(length=40)
	 private String prenom;
	 
	 @Column(length=40)
	 private String nom;
	 
	 @Column(length=40)
	 private String email;
	 
	 private int tel;
	 
	 @Column(length=40)
	 private String adresse;
	 
	 @Temporal(TemporalType.DATE)
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	 private Date datenais;
	 
	@OneToMany(mappedBy="apprenant")
	private List<Evaluation> evaluation;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<Evaluation> getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(List<Evaluation> evaluation) {
		this.evaluation = evaluation;
	}
	 
	 

}
