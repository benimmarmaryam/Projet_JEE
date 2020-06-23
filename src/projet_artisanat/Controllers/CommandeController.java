package projet_artisanat.Controllers;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import projet_artisanat.Models.CommandeEntity;
import projet_artisanat.Models.LigneCommandeEntity;
import projet_artisanat.Models.ProduitEntity;
import projet_artisanat.Models.UtilisateurEntity;
import projet_artisanat.ServicesImpl.CommandeServiceImpl;
import projet_artisanat.ServicesImpl.LigneCommandeServiceImpl;
import projet_artisanat.ServicesImpl.ProduitServiceImpl;
import projet_artisanat.ServicesImpl.UtilisateurServiceImpl;

@ManagedBean
public class CommandeController {

	public CommandeServiceImpl commandeServiceImpl;
	public List<LigneCommandeEntity> ligneCommandeList;
	public Integer idCommande;
	public String message;
	public int modePaiment = 2;
	
	public CommandeController() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse)context.getExternalContext().getResponse();
		try {
			if(SessionDBUtil.idUser == null) {
				SessionDBUtil.setMessage("Vous devez vous connectez pour consulter le panier");
				response.sendRedirect("Login.xhtml");
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		idCommande = UtilisateurServiceImpl.utilisateurServiceImpl.findById(SessionDBUtil.idUser).getIdpanier();
		if(idCommande !=null)
			ligneCommandeList = LigneCommandeServiceImpl.ligneCommandeServiceImpl.findAllBycmdid(idCommande);
		else {
			try {
					response.sendRedirect("index.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}


	public List<LigneCommandeEntity> getLigneCommandeList() {
		return ligneCommandeList;
	}

	public void setLigneCommandeList(List<LigneCommandeEntity> ligneCommandeList) {
		this.ligneCommandeList = ligneCommandeList;
	}
	
	public ProduitEntity produitById(int id) {
		return ProduitServiceImpl.produitServiceImpl.findById(id);
	}
	
	public void incremete(LigneCommandeEntity lignecommande){
		if (idCommande !=null && lignecommande.getQte()+1 <= ProduitServiceImpl.produitServiceImpl.findById(lignecommande.getProdid()).getQtestock()) {
			lignecommande.setQte(lignecommande.getQte()+1);
			LigneCommandeServiceImpl.ligneCommandeServiceImpl.save(lignecommande);
		}
	}
	
	public void decremete(LigneCommandeEntity lignecommande){
		if (idCommande !=null && lignecommande.getQte() > 1) {
			lignecommande.setQte(lignecommande.getQte()-1);
			LigneCommandeServiceImpl.ligneCommandeServiceImpl.save(lignecommande);
		}
	}
	
	public double prix() {
		double somme = 0;
		if (idCommande !=null)
			for(LigneCommandeEntity l : ligneCommandeList) {
				somme += ProduitServiceImpl.produitServiceImpl.findById(l.getProdid()).getPdtprix()*l.getQte();
			}
		return somme;
	}
	
	public String clotureCommande(){
		CommandeEntity commande = CommandeServiceImpl.commandeServiceImpl.findById(idCommande);
		//mode paiement
		commande.setCmdetat(modePaiment);
		CommandeServiceImpl.commandeServiceImpl.save(commande);
		UtilisateurEntity utilisateur = UtilisateurServiceImpl.utilisateurServiceImpl.findById(SessionDBUtil.idUser);
		utilisateur.setIdpanier(null);
		UtilisateurServiceImpl.utilisateurServiceImpl.save(utilisateur);
		SessionDBUtil.setMessage("Commande effectué avec succés");
		return "/index.xhtml?faces-redirect=true";
	}


	public int getModePaiment() {
		return modePaiment;
	}


	public void setModePaiment(int modePaiment) {
		this.modePaiment = modePaiment;
	}
	
	public String checkout() {
		if(idCommande !=null) 
			return "checkout.xhtml?faces-redirect=true";
		else {
			return "cart.xhtml";
		}
			
	}
	
}
