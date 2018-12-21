package beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import entities.Moniteur;
import entities.Personne;
import entities.Plongeur;
import services.PlongeeServicesLocal;

@ManagedBean
@SessionScoped
public class LoginBean {
	
	private Personne p= new Personne();
	private String login;
	private String password;
	
	@EJB
	PlongeeServicesLocal psl;
	
	public String loginuser()
	{
		String navigatto=null;
		System.out.println("*******************************************");
		p= psl.authentification(login, password);
		
		if (p!=null && p instanceof Moniteur)
		{
			navigatto="/pages/Moniteur?faces-redirect=true";
			System.out.println("*******************************************");
			
		}else if (p!=null && p instanceof Plongeur) {
			navigatto="/pages/Plongeur?faces-redirect=true";
			
		}
		else
		{
			navigatto="/pages/Error?faces-redirect=true";
			
		}
		System.out.println(p.getNom());
		
		return navigatto;
		
	}

	public Personne getP() {
		return p;
	}

	public void setP(Personne p) {
		this.p = p;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	

}
