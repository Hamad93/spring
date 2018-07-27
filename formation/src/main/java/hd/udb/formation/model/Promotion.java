package hd.udb.formation.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Promotion {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int id;
	
	 @Temporal(TemporalType.DATE)
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	 private Date datedebut;
	 
	 @Temporal(TemporalType.DATE)
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	 private Date datefin;
	 
	 @OneToMany(mappedBy="promotion")
	 private List<Evaluation> evaluation;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	public List<Evaluation> getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(List<Evaluation> evaluation) {
		this.evaluation = evaluation;
	}
	 
	 
}
