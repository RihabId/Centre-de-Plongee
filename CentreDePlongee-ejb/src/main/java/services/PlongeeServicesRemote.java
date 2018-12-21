package services;

import java.util.List;

import javax.ejb.Remote;

import entities.Moniteur;
import entities.Personne;
import entities.Plongeur;
import entities.SeancePlongee;

@Remote
public interface PlongeeServicesRemote {
	public void ajouter(Personne personne);
	public void ajouterMoniteurSeancePlongee(Moniteur moniteur, SeancePlongee seancepleangee);
	public List<SeancePlongee> listerseanceplonge(Moniteur m);
	public List<SeancePlongee> listerseanceplongeparplongeur(Plongeur p);
	public Moniteur selectmoniteur(SeancePlongee s);
}
