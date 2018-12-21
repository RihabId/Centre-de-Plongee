package beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import entities.Moniteur;
import entities.Plongeur;
import entities.SeancePlongee;
import services.PlongeeServicesLocal;

@ManagedBean
@ViewScoped
public class PlongeurBean {
	
	private List<SeancePlongee> ls= new ArrayList<SeancePlongee>();
	private SeancePlongee s;
	private Moniteur m;
	private String nom;
	private String prenom;
	private boolean b=false;
	
	@ManagedProperty(value="#{loginBean}")
	LoginBean lb;


	@EJB
	PlongeeServicesLocal psl;
	
	@PostConstruct
	public void init()
	{
		System.out.println("******Plongeur BEAN");
		ls= psl.listerseanceplongeparplongeur((Plongeur) lb.getP());
		
	}
	
	public void selectMonitor(SeancePlongee s)
	{
		b=true;
		m= psl.selectmoniteur(s);
		nom=m.getNom();
		prenom= m.getPrenom();
		System.out.println("ACTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTION"+ m.getNom());
		System.out.println("555555555555555555"+nom);
		
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<SeancePlongee> getLs() {
		return ls;
	}

	public void setLs(List<SeancePlongee> ls) {
		this.ls = ls;
	}

	public LoginBean getLb() {
		return lb;
	}

	public void setLb(LoginBean lb) {
		this.lb = lb;
	}

	public PlongeeServicesLocal getPsl() {
		return psl;
	}

	public void setPsl(PlongeeServicesLocal psl) {
		this.psl = psl;
	}

	public SeancePlongee getS() {
		return s;
	}

	public void setS(SeancePlongee s) {
		this.s = s;
	}

	public Moniteur getM() {
		return m;
	}

	public void setM(Moniteur m) {
		this.m = m;
	}

	public boolean isB() {
		return b;
	}

	public void setB(boolean b) {
		this.b = b;
	}
	
	
	
	
	
}
