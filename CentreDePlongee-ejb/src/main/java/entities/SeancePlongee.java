package entities;

import java.io.Serializable;
import java.lang.Float;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: SeancePlongee
 *
 */
@Entity

public class SeancePlongee implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Float prix;
	private int pronfondeur;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Personne moniteur;
	@Enumerated(EnumType.STRING)
	private Niveau nv;
	@ManyToMany
	private List<Personne> plongeurs;
	private static final long serialVersionUID = 1L;

	public SeancePlongee() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public Float getPrix() {
		return this.prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}   
	public int getPronfondeur() {
		return this.pronfondeur;
	}

	public void setPronfondeur(int pronfondeur) {
		this.pronfondeur = pronfondeur;
	}
	public Personne getMoniteur() {
		return moniteur;
	}
	public void setMoniteur(Personne moniteur) {
		this.moniteur = moniteur;
	}
	public List<Personne> getPlongeurs() {
		return plongeurs;
	}
	public void setPlongeurs(List<Personne> plongeurs) {
		this.plongeurs = plongeurs;
	}
	public Niveau getNv() {
		return nv;
	}
	public void setNv(Niveau nv) {
		this.nv = nv;
	}
	
   
}
