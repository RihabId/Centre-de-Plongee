package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Plongeur
 *
 */
@Entity

public class Plongeur extends Personne implements Serializable {

	@Temporal(TemporalType.DATE)
	private Date Abonnement;
	private static final long serialVersionUID = 1L;

	public Plongeur() {
		super();
	}   
	public Date getAbonnement() {
		return this.Abonnement;
	}

	public void setAbonnement(Date Abonnement) {
		this.Abonnement = Abonnement;
	}
   
}
