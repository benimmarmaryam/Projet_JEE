package projet_artisanat.Services;

import java.util.List;

import projet_artisanat.Models.CommandeEntity;

public interface CommandeService {

	CommandeEntity findById(Integer id);
	List<CommandeEntity> findCateAll();
    void save(CommandeEntity commande);
    
}
