package projet_artisanat.Controllers;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import projet_artisanat.Models.CommandeEntity;
import projet_artisanat.Models.LigneCommandeEntity;
import projet_artisanat.Models.LigneCommandeEntityPK;
import projet_artisanat.Models.ProduitEntity;
import projet_artisanat.Models.UtilisateurEntity;
import projet_artisanat.ServicesImpl.CommandeServiceImpl;
import projet_artisanat.ServicesImpl.LigneCommandeServiceImpl;
import projet_artisanat.ServicesImpl.ProduitServiceImpl;
import projet_artisanat.ServicesImpl.UtilisateurServiceImpl;

@ManagedBean
public class ProduitController {
	
	public ProduitServiceImpl produitServiceImpl ;
	public ProduitEntity produit;
	public int pdtid;
	public int utilid = SessionDBUtil.idUser;
	public int qte = 1;
	
	public ProduitController() {
		produitServiceImpl = ProduitServiceImpl.produitServiceImpl;
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		if(!params.containsKey("id"))
			pdtid = SessionDBUtil.pdtid;
		else {				
			pdtid = Integer.parseInt(params.get("id"));
			SessionDBUtil.pdtid = pdtid;
		}
		System.out.println("id :"+ pdtid);
		produit = produitServiceImpl.findById(pdtid);
	}

	public ProduitEntity getProduit() {
		return produit;
	}

	public void setProduit(ProduitEntity produit) {
		this.produit = produit;
	}
	

    public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public String ajoutAuPanier() {

		UtilisateurEntity utilisateur = UtilisateurServiceImpl.utilisateurServiceImpl.findById(utilid);
    	int commandeid;
    	
    	if(utilisateur.getIdpanier() == null) {
    		//New command
    		commandeid=  CommandeServiceImpl.commandeServiceImpl.findCateAll().stream().max((c1, c2) -> c1.getCmdid()-c2.getCmdid()).get().getCmdid();
    		CommandeEntity commande = new CommandeEntity(commandeid+1, 1, utilisateur.getUtilid());
    		CommandeServiceImpl.commandeServiceImpl.save(commande);

    		// Update Cart id
    		utilisateur.setIdpanier(commandeid);
    		UtilisateurServiceImpl.utilisateurServiceImpl.save(utilisateur);
    	}else {
    		//get the old command id
    		commandeid = utilisateur.getIdpanier();	
    	}
    	
    	//ajout d'une nouvelle ligne de commande
    	LigneCommandeEntity ligneCommande = LigneCommandeServiceImpl.ligneCommandeServiceImpl.findByPk(new LigneCommandeEntityPK(pdtid , commandeid));
    	if(ligneCommande == null) {
    		ligneCommande = new LigneCommandeEntity(pdtid , commandeid, qte);
    	}else{
    		ligneCommande.setQte(qte);
    	}
    	LigneCommandeServiceImpl.ligneCommandeServiceImpl.save(ligneCommande);

        return "/cart.xhtml?faces-redirect=true";
    }
	
}
