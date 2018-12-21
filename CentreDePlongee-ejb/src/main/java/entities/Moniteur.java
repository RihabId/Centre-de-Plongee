package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Moniteur
 *
 */
@Entity

public class Moniteur extends Personne implements Serializable {

	
	private Date DateEmbauche;
	private int Experience;
	private static final long serialVersionUID = 1L;

	public Moniteur() {
		super();
	}   
	public Date getDateEmbauche() {
		return this.DateEmbauche;
	}

	public void setDateEmbauche(Date DateEmbauche) {
		this.DateEmbauche = DateEmbauche;
	}   
	public int getExperience() {
		return this.Experience;
	}

	public void setExperience(int Experience) {
		this.Experience = Experience;
	}
   
}
