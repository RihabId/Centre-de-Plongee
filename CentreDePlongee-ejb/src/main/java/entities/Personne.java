package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Personne
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Personne implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private Date DateDeNaissance;
	private String login;
	private String password;
	@OneToMany(mappedBy="moniteur")
	private List<SeancePlongee> lspmoniteur;
	@ManyToMany(mappedBy="plongeurs")
	private List<SeancePlongee> lsplongeur;
	private static final long serialVersionUID = 1L;

	public Personne() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}   
	public Date getDateDeNaissance() {
		return this.DateDeNaissance;
	}

	public void setDateDeNaissance(Date DateDeNaissance) {
		this.DateDeNaissance = DateDeNaissance;
	}   
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public List<SeancePlongee> getLspmoniteur() {
		return lspmoniteur;
	}
	public void setSp(List<SeancePlongee> lspmoniteur) {
		this.lspmoniteur = lspmoniteur;
	}
	public List<SeancePlongee> getLsplongeur() {
		return lsplongeur;
	}
	public void setLsplongeur(List<SeancePlongee> lsplongeur) {
		this.lsplongeur = lsplongeur;
	}
	public void setLspmoniteur(List<SeancePlongee> lspmoniteur) {
		this.lspmoniteur = lspmoniteur;
	}
	
   
}
