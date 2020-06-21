package projet_artisanat.Services;

import java.util.List;

import projet_artisanat.Models.LigneCommandeEntity;
import projet_artisanat.Models.LigneCommandeEntityPK;

public interface LigneCommandeService {
	
	List<LigneCommandeEntity> findAllBycmdid(Integer id);
	LigneCommandeEntity findByPk(LigneCommandeEntityPK ligneCommandePk);
    void save(LigneCommandeEntity ligneCommande);

}
