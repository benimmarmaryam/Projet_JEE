package projet_artisanat.Services;


import java.util.List;

import projet_artisanat.Models.ProduitEntity;

public interface ProduitService {
	
    List<ProduitEntity> findAll();
    ProduitEntity findById(Integer id);
    
}
