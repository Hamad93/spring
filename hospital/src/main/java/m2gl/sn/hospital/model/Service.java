package m2gl.sn.hospital.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Service {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=40)
	private String libelle;
	
	@OneToMany(mappedBy="service")
	private List<Medecin> medecins;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public List<Medecin> getMedecins() {
		return medecins;
	}
	public void setMedecins(List<Medecin> medecins) {
		this.medecins = medecins;
	}
	
	
	
}
