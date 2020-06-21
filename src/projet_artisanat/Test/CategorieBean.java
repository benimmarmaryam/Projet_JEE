package projet_artisanat.Test;

import javax.faces.bean.ManagedBean;

import projet_artisanat.ServicesImpl.CategorieServiceImpl;

@ManagedBean
public class CategorieBean {
	
	CategorieServiceImpl categorieServiceImpl;
	
	public String lib;

	public String getLib() {
		return new CategorieServiceImpl().findById(1).getCatlib();
	}

	public void setLib(String lib) {
		this.lib = lib;
	}
	
	

}
