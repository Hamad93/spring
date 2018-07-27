package hd.udb.formation.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Module {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int id;
	 
	 private int coefficient;
	 
	 @Column(length=40)
	 private String libelle;
	 
	 @OneToOne
	 @JoinColumn(name="enseignant_id")
	 private Enseignant enseignant;
	 
	 @OneToMany(mappedBy="module")
	 private List<Evaluation> evaluation;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public List<Evaluation> getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(List<Evaluation> evaluation) {
		this.evaluation = evaluation;
	}
	 
	 

}
