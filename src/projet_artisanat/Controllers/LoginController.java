package projet_artisanat.Controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import projet_artisanat.Models.LigneCommandeEntity;
import projet_artisanat.Models.UtilisateurEntity;
import projet_artisanat.ServicesImpl.UtilisateurServiceImpl;

@ManagedBean
@SessionScoped
public class LoginController {
	static UtilisateurEntity utilisater = new UtilisateurEntity();
	static String message;
	
	public LoginController() {
		message = SessionDBUtil.getMessage();
		SessionDBUtil.setMessage("");
	}

	public UtilisateurEntity getUtilisater() {
		return utilisater;
	}

	public void setUtilisater(UtilisateurEntity utilisater) {
		LoginController.utilisater = utilisater;
	}
	
	public String seConnecter() {
		UtilisateurEntity utilsateurDb = UtilisateurServiceImpl.utilisateurServiceImpl.findByLogin(utilisater.getUtillogin());
		if(utilsateurDb == null) {
			message = "L'utilisateur "+utilisater.getUtillogin()+ " n'existe pas";
		}else if(!utilsateurDb.getUtilpass().equals(utilisater.getUtilpass())) {
			message =  "Mot de passe incorect";
		}else {
			SessionDBUtil.idUser = utilsateurDb.getUtilid();
			return "/index.xhtml?faces-redirect=true";
		}
		return "Login";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		LoginController.message = message;
	}
	
	public void modifyQuantity(LigneCommandeEntity lignecommande){
		
	}
	
}
