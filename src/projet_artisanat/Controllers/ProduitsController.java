package projet_artisanat.Controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;

import projet_artisanat.Models.ProduitEntity;
import projet_artisanat.ServicesImpl.ProduitServiceImpl;

@ManagedBean
public class ProduitsController {
	
	public ProduitServiceImpl produitServiceImpl ;
	public String message;
	
	public List<ProduitEntity> listProduits;
	public int taille;
	
	public ProduitsController() {
		message = SessionDBUtil.getMessage();
		SessionDBUtil.setMessage("");
		produitServiceImpl = ProduitServiceImpl.produitServiceImpl;
		listProduits = produitServiceImpl.findAll();
		this.taille = listProduits.size();
	}

	public List<ProduitEntity> getListProduits() {
		return listProduits;
	}

	public void setListProduits(List<ProduitEntity> listProduits) {
		this.listProduits = listProduits;
	}

	public int getTaille() {
		return listProduits.size();
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public String getMessage() {
		return message;
	}

	
}



