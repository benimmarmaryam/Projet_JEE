package projet_artisanat.Services;

import java.util.List;

import projet_artisanat.Models.CategorieEntity;

public interface CategorieService {
	
	CategorieEntity findById(Integer id);
	List<CategorieEntity> findAll();
	
}
