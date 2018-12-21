package services;

import java.util.List;

import javax.ejb.Local;

import entities.Moniteur;
import entities.Personne;
import entities.Plongeur;
import entities.SeancePlongee;

@Local
public interface PlongeeServicesLocal {
	public void ajouter(Personne personne);
	public void ajouterMoniteurSeancePlongee(Moniteur moniteur, SeancePlongee seancepleangee);
	public Personne authentification(String login, String password);
	public List<SeancePlongee> listerseanceplonge(Moniteur m);
	public List<SeancePlongee> listerseanceplongeparplongeur(Plongeur p);
	public Moniteur selectmoniteur(SeancePlongee s);

}
