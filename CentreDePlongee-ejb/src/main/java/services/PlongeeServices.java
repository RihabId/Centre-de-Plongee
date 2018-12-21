package services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Moniteur;
import entities.Personne;
import entities.Plongeur;
import entities.SeancePlongee;

/**
 * Session Bean implementation class PlongeeServices
 */
@Stateless
@LocalBean
public class PlongeeServices implements PlongeeServicesRemote, PlongeeServicesLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	private EntityManager em;
    public PlongeeServices() {
        // TODO Auto-generated constructor stub
    }
    
    public void ajouter(Personne personne)
    {
    	em.persist(personne);
    	
    }

	@Override
	public void ajouterMoniteurSeancePlongee(Moniteur moniteur, SeancePlongee seancepleangee) {
		
		seancepleangee.setMoniteur(moniteur);
		em.persist(seancepleangee);
	}

	

	@Override
	public Personne authentification(String login, String password) {
		// TODO Auto-generated method stub
		TypedQuery<Personne> qr= em.createQuery("select p from Personne p where p.login=:login and p.password=:password ", Personne.class);
		qr.setParameter("login", login);
		qr.setParameter("password", password);
		Personne p= new Personne();
		try{
		p = qr.getSingleResult();
		
	} catch (NoResultException e ) {
		Logger.getAnonymousLogger();
	}
	
		return p;
	}

	@Override
	public List<SeancePlongee> listerseanceplonge(Moniteur m){ 

		TypedQuery<SeancePlongee> qr= em.createQuery("select e from SeancePlongee e where e.moniteur=:m", SeancePlongee.class);
		qr.setParameter("m", m);
		List<SeancePlongee> l= qr.getResultList();
		return l;
	}

	@Override
	public List<SeancePlongee> listerseanceplongeparplongeur(Plongeur p) {
		TypedQuery<SeancePlongee> qr= em.createQuery("select s from SeancePlongee s join s.plongeurs p where p=:p", SeancePlongee.class);
		qr.setParameter("p", p);
		List<SeancePlongee> l= qr.getResultList();
		return l;
		// TODO Auto-generated method stub
//		TypedQuery<SeancePlongee> qr= em.createQuery("select e from SeancePlongee e ", SeancePlongee.class);
//		List<SeancePlongee> ls= qr.getResultList();
//		System.out.println("LLLLLIIIIIISSSSTTTTTTT"+ls.size());
//		List<SeancePlongee> l= new ArrayList<SeancePlongee>();
//		for(SeancePlongee s:ls)
//		{
//			if (s.getPlongeurs().contains(p)==true) 
//			{
//				System.out.println(s.getId());
//				System.out.println("111111111555555555555555511111111");
//				l.add(s);
//			}
//		}
//		
//		return l;
		
	}

	@Override
	public Moniteur selectmoniteur(SeancePlongee s) {
		// TODO Auto-generated method stub
		TypedQuery<Moniteur> qr= em.createQuery("select m from Moniteur m join m.lspmoniteur s where s=:s ", Moniteur.class);
		qr.setParameter("s", s);
		return qr.getSingleResult();
		
	}

    
    
    
}
