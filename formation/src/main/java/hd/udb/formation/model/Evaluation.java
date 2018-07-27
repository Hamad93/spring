package hd.udb.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Evaluation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int id;
	
	@Column(length=40)
	 private String note;
	 
	 @Column(length=40)
	 private String mention;
	 
	 @ManyToOne
	 @JoinColumn(name="apprenant_id")
	 private Apprenant apprenant;
	 
	 @ManyToOne
	 @JoinColumn(name="promotion_id")
	 private Promotion promotion;
	 
	 @ManyToOne
	 @JoinColumn(name="module_id")
	 private Module module;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getMention() {
		return mention;
	}

	public void setMention(String mention) {
		this.mention = mention;
	}

	public Apprenant getApprenant() {
		return apprenant;
	}

	public void setApprenant(Apprenant apprenant) {
		this.apprenant = apprenant;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}
	 
	 
}
