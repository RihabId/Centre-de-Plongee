package beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import entities.Moniteur;
import entities.SeancePlongee;
import services.PlongeeServicesLocal;

@ManagedBean
@ViewScoped
public class MonitorBean {
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean lb;
	
	
	private List<SeancePlongee> ls= new ArrayList<SeancePlongee>();
	
	
	@EJB
	PlongeeServicesLocal psl;
	
	@PostConstruct
	public void init()
	{
		System.out.println("******MONITOR BEAN");
		ls= psl.listerseanceplonge((Moniteur) lb.getP());
		
	}

	public LoginBean getLb() {
		return lb;
	}

	public void setLb(LoginBean lb) {
		this.lb = lb;
	}

	public List<SeancePlongee> getLs() {
		return ls;
	}

	public void setLs(List<SeancePlongee> ls) {
		this.ls = ls;
	}

	public PlongeeServicesLocal getPsl() {
		return psl;
	}

	public void setPsl(PlongeeServicesLocal psl) {
		this.psl = psl;
	}

}
