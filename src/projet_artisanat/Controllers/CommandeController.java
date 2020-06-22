package projet_artisanat.Controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;

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
	public int idCommande;
	public String message;
	public int modePaiment;
	
	public CommandeController() {
		modePaiment = 1;
		idCommande = UtilisateurServiceImpl.utilisateurServiceImpl.findById(SessionDBUtil.idUser).getIdpanier();
		ligneCommandeList = LigneCommandeServiceImpl.ligneCommandeServiceImpl.findAllBycmdid(idCommande);
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
		if (lignecommande.getQte()+1 <= ProduitServiceImpl.produitServiceImpl.findById(lignecommande.getProdid()).getQtestock()) {
			lignecommande.setQte(lignecommande.getQte()+1);
			LigneCommandeServiceImpl.ligneCommandeServiceImpl.save(lignecommande);
		}
	}
	
	public void decremete(LigneCommandeEntity lignecommande){
		if (lignecommande.getQte() > 1) {
			lignecommande.setQte(lignecommande.getQte()-1);
			LigneCommandeServiceImpl.ligneCommandeServiceImpl.save(lignecommande);
		}
	}
	
	public double prix() {
		double somme = 0;
		for(LigneCommandeEntity l : ligneCommandeList) {
			somme += ProduitServiceImpl.produitServiceImpl.findById(l.getProdid()).getPdtprix()*l.getQte();
		}
		return somme;
	}
	
	public void clotureCommande(){
		CommandeEntity commande = CommandeServiceImpl.commandeServiceImpl.findById(idCommande);
		//mode paiement
		CommandeServiceImpl.commandeServiceImpl.save(commande);
		UtilisateurEntity utilisateur = UtilisateurServiceImpl.utilisateurServiceImpl.findById(SessionDBUtil.idUser);
		utilisateur.setIdpanier(null);
		UtilisateurServiceImpl.utilisateurServiceImpl.save(utilisateur);
	}


	public int getModePaiment() {
		return modePaiment;
	}


	public void setModePaiment(int modePaiment) {
		this.modePaiment = modePaiment;
	}
	
	
}
